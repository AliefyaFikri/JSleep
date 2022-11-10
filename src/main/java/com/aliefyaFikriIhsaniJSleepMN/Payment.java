package com.aliefyaFikriIhsaniJSleepMN;

import java.util.Calendar;
import java.util.Date;

public class Payment extends Invoice
{
    
    public String to;
    public String from;
    private int roomId;
    
    public Payment (Account buyerId, Room renterId, int roomId, String from, String to){
        super();
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment (Account buyer, Renter renter, int roomId, String from, String to){
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public String print() {
        String print = "\nRoom Id : " + roomId + "\nFrom : " + from + "\nTo : " + to;
        return print;
    }
    
    public int getRoomId()
    {
        return roomId;
    }

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
    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){
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


}
