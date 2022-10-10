package aliefyaFikriIhsaniJSleepMN;
import java.util.Calendar;
import java.util.Date;

public class Invoice extends Serializable
{
    public enum RoomRating { NONE, BAD, NEUTRAL, GOOD};
    public enum PaymentStatus { FAILED, WAITING, SUCCESS};
    public int buyerId;
    public int renterId;
    public Date time;
    public PaymentStatus status;
    public RoomRating rating;
    
    protected Invoice(int id, int buyerId, int renterId)
    {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
        
    }

    public Invoice(int id, Account buyer, Renter renter){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    public String print(){
        String print = "Id : " + super.id +
                       "\nBuyer Id : " + buyerId + 
                       "\nRenter Id : " + renterId +
                       "\ntime : " + time;
        return print;
    }
    
    
}
