package aliefyaFikriIhsaniJSleepMN;

public class Complaint extends Serializable{

    public String desc;
    public String date;
    
    public Complaint (int id, String date, String desc){
        super();
        this.date = date;
        this.desc = desc;
    }
    
    public String toString(){
        String print =
                   "\nDesc: " + desc +
                   "\nDate: " + date;
        return print;
    }
    
}
