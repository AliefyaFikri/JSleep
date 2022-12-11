package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.Account;
import com.aliefyaFikriIhsaniJSleepMN.Algorithm;
import com.aliefyaFikriIhsaniJSleepMN.Renter;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;

/**
 * Kelas AccountController merupakan kelas yang berfungsi untuk mengatur
 * proses register, login, register renter, dan top up
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    @JsonAutowired(value=Account.class,filepath="C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\account.json")
    public static JsonTable<Account> accountTable;
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    /**
     * Method register merupakan method yang berfungsi untuk melakukan register
     *
     * @param name merupakan username dari akun yang akan diregister
     * @param email merupakan email dari akun yang akan diregister
     * @param password merupakan password dari akun yang akan diregister
     */
    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        final String generatedPass;
        Matcher matcher_email = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher matcher_password = REGEX_PATTERN_PASSWORD.matcher(password);
        Account findEmail = Algorithm.<Account> find(getJsonTable(), pred -> Objects.equals(pred.email, email));

        if(matcher_email.find() && matcher_password.find() && !name.isBlank() && findEmail == null){
            generatedPass = hashPassword(password);
            Account account = new Account(name, email, generatedPass);
            accountTable.add(account);
            return account;
        }
        return null;
    }

    /**
     * Method login merupakan method yang berfungsi untuk melakukan login
     *
     * @param email merupakan email dari akun yang akan login
     * @param password merupakan password dari akun yang akan login
     */
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        final String generatedPass = hashPassword(password);
        return Algorithm.<Account>find(accountTable, pred -> Objects.equals(pred.email, email) && Objects.equals(pred.password, generatedPass));
    }

    /**
     * Method registerRenter merupakan method yang berfungsi untuk melakukan register renter
     *
     * @param id merupakan id dari akun yang akan diregister renter
     * @param name merupakan username dari akun renter yang akan diregister
     * @param address merupakan alamat dari akun renter yang akan diregister
     * @param phoneNumber merupakan nomor telepon dari akun renter yang akan diregister
     */
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) { Account test = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(test.renter == null){
            test.renter = new Renter(name, address, phoneNumber);
            return test.renter;
        }
        return null;
    }

    /**
     * Method topUp merupakan method yang berfungsi untuk melakukan top up
     *
     * @param id merupakan id dari akun yang akan melakukan top up
     * @param balance merupakan besar uang yang akan ditop up
     */
    @PostMapping("{id}/topUp")
    Account topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {
        Account account = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(account != null && balance > 0){
            account.balance += balance;
            return account;
        }
        return null;
    }

    private static String hashPassword(String password){
        String hashedPass = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            hashedPass = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hashedPass;
    }
}
