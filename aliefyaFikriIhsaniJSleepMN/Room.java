package aliefyaFikriIhsaniJSleepMN;

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public City city;
    public BedType bedType;
    public String address;
    
    public Room(int id, String name, int size, Price price, Facility facility, City city, String address){
        super(id);
        this.name = name;
        this.size = size;
        this.facility = facility;
        this.price = price;
        this.address = address;
        this.city = city;
        this.bedType = BedType.SINGLE;
    }
    
    public String toString(){
        String print = "Name: " + name +
                   "\nSize: " + size +
                   "\n" + price +
                   "\nFacility: " + facility +
                   "\nBed Type: " + bedType +
                   "\nCity: " + city +
                   "\nAddress: " + address;
        return print;
    }
    
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
}
