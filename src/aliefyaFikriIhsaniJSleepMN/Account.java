package aliefyaFikriIhsaniJSleepMN;

public class Account extends Serializable implements FileParser{
    
    public String name;
    public String email;
    public String password;
    
    public Account (int id, String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        String print = "Name: " + name +
                   "\nEmail: " + email +
                   "\nPassword: " + password;
        return print;
    }
    
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
}