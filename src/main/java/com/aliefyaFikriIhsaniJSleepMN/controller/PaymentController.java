package com.aliefyaFikriIhsaniJSleepMN.controller;


import com.aliefyaFikriIhsaniJSleepMN.Account;
import com.aliefyaFikriIhsaniJSleepMN.Payment;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{

    @JsonAutowired
    (value= Account.class,
    filepath = "\"C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\payment.json\"")

    public static JsonTable<Payment> paymentTable;

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
    )
    {
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
