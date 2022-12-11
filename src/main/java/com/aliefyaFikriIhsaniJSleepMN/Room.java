package com.aliefyaFikriIhsaniJSleepMN;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Kelas Room merupakan kelas yang mendefinisikan Room yang digunakan pada program
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */
public class Room extends Serializable
{
    public int size;
    public int accountId;
    public String name;
    public Facility[] facility;
    public Price price;
    public City city;
    public BedType bedType;
    public String address;
    public ArrayList<Date> booked = new ArrayList<Date>();

    /**
     * Constructor dari kelas Room
     * @param accountId merupakan id dari account yang memiliki room
     * @param name merupakan nama dari room
     * @param size merupakan ukuran dari room
     * @param price merupakan harga dari room
     * @param facility merupakan fasilitas dari room
     * @param city merupakan kota letak room
     * @param address merupakan alamat dari room
     * @param bedType merupakan tipe tempat tidur dari room
     */
    
    public Room(int accountId, String name, int size, Price price, Facility[] facility, City city, String address, BedType bedType){
        super();
        this.name = name;
        this.size = size;
        this.facility = new Facility[facility.length];
        for (int i = 0; i < facility.length; i++) {
            this.facility[i] = facility[i];
        }
        this.price = price;
        this.address = address;
        this.city = city;
        this.bedType = bedType;
        this.accountId = accountId;
    }

    /**
     * Method toString untuk menampilkan informasi dari room
     * @return print
     */
public String toString(){
        String print = "\nName: " + name +
                "\nSize: " + size +
                "\n" + price +
                "\nFacility: " + facility +
                "\nBed Type: " + bedType +
                "\nCity: " + city +
                "\nAddress: " + address +
                "\nId: " + accountId ;
        return print;
    }

    
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
}
