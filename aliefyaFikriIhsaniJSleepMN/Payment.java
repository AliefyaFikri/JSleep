package aliefyaFikriIhsaniJSleepMN;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Payment extends Invoice
{
    
    public Calendar to;
    public Calendar from;
    private int roomId;
    
    public Payment (int id, int buyerId, int renterId, int roomId){
        super(id, buyerId, renterId);
        this.time = time;
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        
    }
    
    public Payment (int id, Account buyer, Renter renter, int roomId){
        super(id, buyer, renter);
        this.time = time;
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
     public String print() {
        String print = "\nBuyer Id : " + buyerId +"\nRenter Id : " + renterId + "\nRoom Id : " + roomId + "\nTime : " + time 
        + "\nFrom : " + from + "\nTo : " + to;
        return print;
    }
    
    public int getRoomId(){
        return roomId;
    }
    
    public String getTime(){
        SimpleDateFormat Duration = new SimpleDateFormat("'Formatted Date= 'dd MMMMM yyyy");
        return Duration.format(time.getTime());
    }
    
    public String getDuration(){
        SimpleDateFormat Duration = new SimpleDateFormat("dd MMMMM yyyy");
        return Duration.format(from.getTime()) + " - " + Duration.format(to.getTime());
    }
}
