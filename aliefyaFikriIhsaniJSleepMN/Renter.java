package aliefyaFikriIhsaniJSleepMN;

public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public int phoneNumber;
    public String address;
    public String username;
    
    public Renter(int id, String username)
    {
        super(id);
        this.username = username;
    }
    
    public Renter(int id, String username, String address)
    {
        super(id);
        this.username = username; 
        this.address = address;
    }

    public Renter(int id, String username, int phoneNumber)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    
    public Renter(int id, String username, int phoneNumber, String address)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}