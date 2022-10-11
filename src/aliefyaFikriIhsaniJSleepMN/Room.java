package aliefyaFikriIhsaniJSleepMN;
import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public City city;
    public BedType bedType;
    public String address;
    public ArrayList<Date> booked;
    
    public Room(String name, int size, Price price, Facility facility, City city, String address){
        super();
        this.name = name;
        this.size = size;
        this.facility = facility;
        this.price = price;
        this.address = address;
        this.city = city;
        this.bedType = BedType.SINGLE;
    }
    
    public String toString(){
        String print = "\nName: " + name +
                "\nSize: " + size +
                "\n" + price +
                "\nFacility: " + facility +
                "\nBed Type: " + bedType +
                "\nCity: " + city +
                "\nAddress: " + address +
                "\nId: " + id ;
        return print;
    }
    
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
}
