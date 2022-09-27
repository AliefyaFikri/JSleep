package aliefyaFikriIhsaniJSleepMN;

public class Payment extends Invoice
{
    
    public String to;
    public String from;
    private int roomId;
    
    public Payment (int id, int buyerId, int renterId, String time, int roomId, String from, String to){
        super(id, buyerId, renterId, time);
        this.time = time;
        this.roomId = roomId;
        this.from = from;
        this.to = to;
        
    }
    
    public Payment (int id, Account buyer, Renter renter, String time, int roomId, String from, String to){
        super(id, buyer, renter, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
     public String print() {
        String print = "\nBuyer Id : " + buyerId +"\nRenter Id : " + renterId + "\nRoom Id : " + roomId + "\nTime : " + time 
        + "\nFrom : " + from + "\nTo : " + to;
        return print;
    }
    
    public int getRoomId(){
        return roomId;
    }
}
