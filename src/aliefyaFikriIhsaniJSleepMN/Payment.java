package aliefyaFikriIhsaniJSleepMN;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Payment extends Invoice
{
    
    public Date to;
    public Date from;
    private int roomId;
    
    public Payment (int id, int buyerId, int renterId, int roomId, Date from, Date to){
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment (int id, Account buyer, Renter renter, int roomId, Date from, Date to){
        super(id, buyer, renter);
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
    
    public String getTime(){
        SimpleDateFormat Duration = new SimpleDateFormat("'Formatted Date= 'dd MMMMM yyyy");
        String formattedFrom = Duration.format(time.getTime());
        return formattedFrom;
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
    
    public static boolean makeBooking(Date from, Date to, Room room){
        SimpleDateFormat Duration = new SimpleDateFormat("dd MMMMM yyyy");
        String formattedFrom = Duration.format(from.getTime());
        String formattedTo = Duration.format(to.getTime());
        Calendar c = Calendar.getInstance();
        
        if(availability(from, to, room)){
            while(from.before(to)){
                room.booked.add(from);
                c.setTime(from);
                c.add(Calendar.DATE, 1);
                from = c.getTime();
            }
            return true;
        }else{
            return false;
        }
    }
 
}
