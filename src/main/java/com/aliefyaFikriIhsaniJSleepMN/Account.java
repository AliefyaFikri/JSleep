package com.aliefyaFikriIhsaniJSleepMN;

import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Kelas Account merupakan kelas yang merepresentasikan account dari user yang digunakan pada aplikasi
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */

public class Account extends Serializable
{

    public String name;
    public String email;
    public String password;
    public Renter renter;

    public static final String REGEX_EMAIL = "^[A-Z0-9._%+-]@[A-Za-z.-]\\.[a-z]$";


    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])*[a-zA-Z\\d]{8,}$";
    public double balance;

    /**
     * Constructor dari kelas Account
     *
     * @param name merupakan username dari akun
     * @param email merupakan email dari akun
     * @param password merupakan password dari akun
     */
    public Account (String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * validate merupakan method yang berfungsi untuk melakukan validasi email dan password
     *
     * @return email dan pass yang sudah di validasi
     */
    public boolean validate(){
        Pattern patternEmail = Pattern.compile(this.REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(this.email);
        boolean matchFoundEmail = matcherEmail.find();

        Pattern patternPassword = Pattern.compile(this.REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(this.name);
        boolean matchFoundPassword = matcherPassword.find();

        return matchFoundEmail && matchFoundPassword;

    }
    public String toString(){
        return "Account{name='"+name+"', email='"+email+"', password='"+password+"', id='"+id+"'}";




    }
}