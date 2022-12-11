package com.aliefyaFikriIhsaniJSleepMN;

import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;

/** Kelas Invoice berfungsi sebagai kelas yang berisi data yang ada dalam invoice
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */

public class Invoice extends Serializable
{
    public enum RoomRating { NONE, BAD, NEUTRAL, GOOD};
    public enum PaymentStatus { FAILED, WAITING, SUCCESS};
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;

    /** Constructor dari kelas Invoice
     *
     */
    protected Invoice(int buyerId, int renterId)
    {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
        
    }

    /** Method Invoice berfungsi untuk mengembalikan nilai-nilai yang ada di invoice
     *
     */
    public Invoice( Account buyer, Renter renter){
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }

    /** Method Print berfungsi untuk mencetak invoice
     *
     * @return print
     */
    public String print(){
        String print = "Id : " + super.id +
                       "\nBuyer Id : " + buyerId + 
                       "\nRenter Id : " + renterId ;
        return print;
    }
    
    
}
