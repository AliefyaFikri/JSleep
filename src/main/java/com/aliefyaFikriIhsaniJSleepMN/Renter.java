package com.aliefyaFikriIhsaniJSleepMN;

import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String phoneNumber;
    public String address;
    public String username;
    public static final String REGEX_NAME = "^[A-Z][^\\s][A-Za-z0-9_]{3,19}$";

    public static final String REGEX_PHONE = "^[0-9]{8,12}";
    
/*    public Renter(int id, String username)
    {
        super();
        this.username = username;
    }
    
    public Renter(int id, String username, String address)
    {
        super();
        this.username = username; 
        this.address = address;
    }

    public Renter(int id, String username, int phoneNumber)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
*/
    public Renter(String username, String phoneNumber, String address)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    public boolean validate(){

        Pattern patPhone = Pattern.compile(REGEX_PHONE);
        Matcher matPhone = patPhone.matcher(phoneNumber);
        boolean phoneFound = matPhone.find();

        Pattern patName = Pattern.compile(REGEX_NAME);
        Matcher matName = patName.matcher(username);
        boolean nameFound =  matName.find();

        return phoneFound && nameFound;

    }

}
