package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.Account;
import com.aliefyaFikriIhsaniJSleepMN.Algorithm;
import com.aliefyaFikriIhsaniJSleepMN.Renter;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_EMAIL = "^[A-Z0-9._%+-]@[A-Za-z.-]\\.[a-z]$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])*[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static JsonTable<Account> accountTable;

    @JsonAutowired
            (value = Account.class,
    filepath = "\"C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\account.json\"")
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }


    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password);
    }

    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        Account account = Algorithm.<Account>find(accountTable, pred -> pred.email.equals(email));
            if (account != null){
                if(account.password.equals(password)){
                    return account;
                }
            }
            return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {

        return false;
    }

    @PostMapping("/{id}/registerStore")
    Renter registerRenter
            (
                    @PathVariable int id,
                    @RequestParam String name,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {

        return null;
    }


}
