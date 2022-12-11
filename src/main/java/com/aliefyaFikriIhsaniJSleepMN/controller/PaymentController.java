package com.aliefyaFikriIhsaniJSleepMN.controller;


import com.aliefyaFikriIhsaniJSleepMN.*;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.aliefyaFikriIhsaniJSleepMN.controller.AccountController.accountTable;
import static com.aliefyaFikriIhsaniJSleepMN.controller.RoomController.roomTable;

/**
 * Kelas PaymentController merupakan kelas yang berfungsi untuk membuat payment dari Detail Room
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{

    @JsonAutowired
    (value= Payment.class,
            filepath = "C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\payment.json")

    public static JsonTable<Payment> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    /** Method create merupakan method yang berfungsi untuk membuat payment dari Detail Room
     *
     * @param buyerId merupakan id dari buyer
     * @param renterId merupakan id dari renter
     * @param roomId merupakan id dari room
     * @param from  merupakan tanggal awal dari booking
     * @param to merupakan tanggal akhir dari booking
     */

    @PostMapping("/createPayment")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        Account createAcc = Algorithm.<Account>find(new AccountController().getJsonTable(), predicate -> predicate.id == buyerId);
        Room createRoom = Algorithm.<Room>find(new RoomController().getJsonTable(), predicate -> predicate.id == roomId);
        Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
        double price =  createRoom.price.price;
        boolean acc = createAcc.balance >= price;



        if(roomTable != null){
            createAcc.balance -= price;
            paymentTable.add(payment);
            payment.status = Invoice.PaymentStatus.valueOf("WAITING");
            Payment.makeBooking(fromDate, toDate, createRoom);
            return payment;
        }
        return null;
    }

    /** Method accept merupakan method yang berfungsi untuk menerima payment dari Detail Room
     *
     * @param id merupakan id dari payment
     */

    @PostMapping("/{id}/accept")
    public boolean accept (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);

        if(payment.status ==  Invoice.PaymentStatus.WAITING){
            Room findroom = Algorithm.<Room>find(roomTable,pred -> pred.id == payment.getRoomId());
            Account account = Algorithm.<Account>find(accountTable, pred -> pred.id == payment.buyerId);
            payment.status =  Invoice.PaymentStatus.SUCCESS;
            account.balance -= findroom.price.price;
            Payment.makeBooking(payment.from, payment.to, findroom);
            return true;
        }
        return false;
    }


    /** Method cancel merupakan method yang berfungsi cancel proses payment dari Detail Room
     *
     * @param id merupakan id dari payment
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if(payment.status ==  Invoice.PaymentStatus.WAITING){
            Account findAccount = Algorithm.<Account>find(accountTable, pred -> pred.id == payment.buyerId);
            Room findRoom = Algorithm.<Room>find(roomTable, pred -> pred.id == payment.getRoomId());
            payment.status =  Invoice.PaymentStatus.FAILED;
            findAccount.balance += findRoom.price.price;
            Payment.removeBooking(payment.from, payment.to, findRoom);
            paymentTable.remove(payment);
            return true;
        }
        return false;
    }


    @GetMapping("/get")
    public Payment get(@RequestParam int buyerId,
                       @RequestParam int renterId,
                       @RequestParam int roomId) {
        int buyerId1 = Integer.parseInt(String.valueOf(buyerId));
        int renterId1 = Integer.parseInt(String.valueOf(renterId));
        int roomId1 = Integer.parseInt(String.valueOf(roomId));
        return Algorithm.<Payment>find(paymentTable, pred -> pred.buyerId == buyerId1 && pred.renterId == renterId1 && pred.getRoomId() == roomId1);
    }

}
