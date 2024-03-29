package com.aliefyaFikriIhsaniJSleepMN;

import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;

/** Kelas Voucher berfungsi sebagai kelas yang merepresentasikan voucher pada aplikasi
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */

public class Voucher extends Serializable
{
    public String name;
    private boolean used;
    public int code;
    public Type type;
    public double minimum;
    public double cut;
    
    public Voucher (int id, String name, int code, Type type, boolean used, double minimum, double cut){
        super();
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
        
    }
    
    public boolean isUsed(){
        return this.used;
    }
    
    public boolean canApply(double price){
        if (price >= minimum && used == false){
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
    
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
}
