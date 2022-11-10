package com.aliefyaFikriIhsaniJSleepMN.controller;


import com.aliefyaFikriIhsaniJSleepMN.*;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{

    @JsonAutowired
    (value= Payment.class,
    filepath = "\"C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\payment.json\"")

    public static JsonTable<Payment> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        Account createAcc = Algorithm.<Account>find(new AccountController().getJsonTable(), predicate -> predicate.id == buyerId);
        Room createRoom = Algorithm.<Room>find(new RoomController().getJsonTable(), predicate -> predicate.id == roomId);
        Payment payment = new Payment(createAcc, createRoom, renterId, from, to);
        double price =  createRoom.price;
        boolean acc = createAcc.balance >= price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        if(RoomController.roomTable != null){
            createAcc.balance -= price;
            paymentTable.add(payment);
            payment.status = Invoice.PaymentStatus.valueOf("WAITING");
            Payment.makeBooking(fromDate, toDate, createRoom);
            return payment;
        }
        return null;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(

    ){
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(

    ){
        return false;
    }

    @PostMapping("/{id}/submit")
    public boolean submit(

    ){
        return false;
    }

}
