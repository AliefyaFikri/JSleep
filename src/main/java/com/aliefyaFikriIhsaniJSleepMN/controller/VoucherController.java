package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.Algorithm;
import com.aliefyaFikriIhsaniJSleepMN.Voucher;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Kelas VoucherController merupakan kelas yang berfungsi untuk membuat voucher, mencari yang available,
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */
@RestController
@RequestMapping("/Voucher")
public class VoucherController implements BasicGetController<Voucher> {

    @JsonAutowired(value = Voucher.class, filepath = "C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    /**
     * Method isUsed merupakan method yang berfungsi untuk mengecek apakah voucher sudah digunakan atau belum
     * @param id merupakan id dari voucher
     */

    @GetMapping("{id}/isUsed")
    boolean isUsed (@PathVariable int id){
        return Algorithm.<Voucher>find(getJsonTable(), predicate -> predicate.id == id).isUsed();
    }

    /**
     * Method canApply merupakan method yang berfungsi untuk mengecek apakah voucher bisa digunakan atau tidak
     *
     * @param id merupakan id dari voucher
     * @param price merupakan harga dari room
     */

    @GetMapping("{id}/canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price
            )
    {
        return Algorithm.<Voucher>find(getJsonTable(), predicate -> predicate.id == id).canApply(price);
    }

    /**
     * Method getAvailable merupakan method yang berfungsi untuk mencari voucher yang available
     *
     * @param page merupakan halaman dari voucher
     * @param pageSize merupakan ukuran halaman dari voucher
     */

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
