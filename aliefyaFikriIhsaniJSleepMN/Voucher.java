package aliefyaFikriIhsaniJSleepMN;

public class Voucher
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    
    public Voucher (String name, int code, Type type, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        
    }
    
    public boolean isUsed(){
        return this.used;
    }
    
    public boolean canApply(Price price){
        if (price.price >= minimum && used == false){
            return true;
        } else {
            return false;
        }
    }
    
    public double apply(Price price){
        used = true;
        if (this.type == Type.DISCOUNT){
            if (cut > 100){
                cut = 100;
            }
            return price.price * (100 - cut)/100;
        } else {
            if (cut > price.price){
                cut = price.price;
            }
            return price.price - cut;
        }
    }
}
