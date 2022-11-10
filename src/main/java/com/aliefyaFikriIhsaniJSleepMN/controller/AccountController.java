package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.Account;
import com.aliefyaFikriIhsaniJSleepMN.Algorithm;
import com.aliefyaFikriIhsaniJSleepMN.Renter;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.util.regex.Matcher;
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

    String hash (String password){
        String generatedPassword = null;
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            MD5.update(password.getBytes());
            byte[] bytes = MD5.digest();
            StringBuilder SB = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                SB.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = SB.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

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
        Pattern patternEmail = Pattern.compile(this.REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchFoundEmail = matcherEmail.find();

        Pattern patternPassword = Pattern.compile(this.REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();

        Account account = Algorithm.<Account> find(getJsonTable(),predicate -> predicate.email.equals(email));

        String generatedPassword;
        if (matcherEmail == null) {
            generatedPassword = hash(password);
            account = new Account(name, email, generatedPassword);
            getJsonTable().add(account);
            return account;
        } else {
            return null;
        }
    }

    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        Account account = Algorithm.<Account>find(accountTable, predicate -> predicate.email.equals(email) && predicate.password.equals(password));
        String generatedPassword = hash(password);
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
        Account account = Algorithm.<Account>find(getJsonTable(), predicate -> predicate.id == id);
        if (account != null){
            account.balance += balance;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter
            (
                    @PathVariable int id,
                    @RequestParam String name,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {
        Account account = Algorithm.<Account>find(accountTable, predicate -> predicate.id == id);
        if (account != null){
            Renter renter = new Renter(name, address, phoneNumber);
            return renter;
        }
        return null;
    }


}
