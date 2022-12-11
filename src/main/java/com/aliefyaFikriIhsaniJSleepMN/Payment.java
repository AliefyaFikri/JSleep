package com.aliefyaFikriIhsaniJSleepMN;

import java.util.Calendar;
import java.util.Date;

/**
 * Kelas Payment berfungsi sebagai pembayaran dari user untuk membayar room
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */
public class Payment extends Invoice
{
    
    public Date to;
    public Date from;
    private int roomId;

    /**
     * Constructor dari kelas Payment
     */
    public Payment (int buyerId, int renterId, int roomId, Date from, Date to){
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * Method Payment berfungsi untuk mengembalikan nilai-nilai yang ada di payment
     *
     */
    public Payment (Account buyer, Renter renter, int roomId, Date from, Date to){
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * Method Print berfungsi untuk mencetak payment
     *
     * @return print
     */
    public String print() {
        String print = "\nRoom Id : " + roomId + "\nFrom : " + from + "\nTo : " + to;
        return print;
    }
    
    public int getRoomId()
    {
        return roomId;
    }

    /**
     * Method availability berfungsi untuk mengecek apakah room yang dipilih sudah terisi atau belum
     */
    public static boolean availability (Date from, Date to, Room room){
         if(room.booked.isEmpty()){
            return true;
        }
        for(Date i : room.booked){
            if(i.after(from) && i.before(to) || i.equals(from)){
                return false;
            }
        }
        return true;
    }
    /**
     * Method makeBoooking berfungsi untuk membuat booking
     */
    public static boolean makeBooking(Date from,Date to,Room room){
        if (availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

    public static boolean removeBooking(Date from,Date to,Room room){
        if (availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.remove(date);
            }
            return true;
        }
        return false;
    }


}
