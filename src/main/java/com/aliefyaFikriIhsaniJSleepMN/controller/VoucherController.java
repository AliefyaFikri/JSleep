package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.Algorithm;
import com.aliefyaFikriIhsaniJSleepMN.Voucher;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Voucher")
public class VoucherController implements BasicGetController<Voucher> {

    @JsonAutowired(value = Voucher.class, filepath = "\"C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\voucher.json\"")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    @GetMapping("{id}/isUsed")
    boolean isUsed (@PathVariable int id){
        return Algorithm.<Voucher>find(getJsonTable(), predicate -> predicate.id == id).isUsed();
    }

    @GetMapping("{id}/canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price
            )
    {
        return Algorithm.<Voucher>find(getJsonTable(), predicate -> predicate.id == id).canApply(price);
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        List<Voucher> available = new ArrayList<>();
        for (Voucher voucher : getJsonTable()) {
            if (!voucher.isUsed()) {
                available.add(voucher);
            }
        }
        return Algorithm.<Voucher>paginate(available, page, pageSize, predicate -> true);
    }
}
