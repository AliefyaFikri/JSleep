package com.aliefyaFikriIhsaniJSleepMN;

import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;

public class Invoice extends Serializable
{
    public enum RoomRating { NONE, BAD, NEUTRAL, GOOD};
    public enum PaymentStatus { FAILED, WAITING, SUCCESS};
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;
    
    protected Invoice()
    {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
        
    }

    public Invoice( Account buyer, Renter renter){
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    public String print(){
        String print = "Id : " + super.id +
                       "\nBuyer Id : " + buyerId + 
                       "\nRenter Id : " + renterId ;
        return print;
    }
    
    
}
