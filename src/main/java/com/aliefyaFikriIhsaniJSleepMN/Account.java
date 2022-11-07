package com.aliefyaFikriIhsaniJSleepMN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable{
    
    public String name;
    public String email;
    public final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]+@+[A-Za-z]+.+[A-Za-z]$";
    public final String REGEX_PASSWORD = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9]).{8,}$";
    public String password;
    
    public Account (String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean validate(){

        Pattern patEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matEmail = patEmail.matcher(email);
        boolean mailFound = matEmail.find();

        Pattern patPass = Pattern.compile(REGEX_PASSWORD);
        Matcher matPass = patPass.matcher(password);
        boolean passFound =  matPass.find();

        return mailFound && passFound;
    }
    
    public String toString(){
        String print = "Name: " + name +
                   "\nEmail: " + email +
                   "\nPassword: " + password+
                    "\nID: 0\n";
        return print;
    }

}
