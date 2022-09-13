package aliefyaFikriIhsaniJSleepMN;


public class JSleep {
    public static void main (String[] args){
        
    }
    
    public int getHotelId(){
        return 0;
    }
    
    public String getHotelName(){
        return "hotel";
    }
    
    public boolean isDiscount(){
        return true;
    }
    
    public float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount<afterDiscount){
            return 0.0f;
        }
        else {
            return ((beforeDiscount-afterDiscount)/10) ;
        }
    }
    
    public int getDiscountedPrice(int price, float discountPercentage){
        if (discountPercentage > 100.0f){
            return 0;
        } else {
            return price - (int) (price * discountPercentage);
        }
    }
    
    public int getOriginalPrice(int discountedPrice, float discountPercentage){
        return discountedPrice + (int) (discountedPrice * discountPercentage);
    }
    
    public float getAdminFeePercentage(){
        return 0.05f;

    }
    
    public int getAdminFee(int price){
        return (int) (getAdminFeePercentage() * price);

    }
    
    public int getTotalPrice(int price, int numberOfNight){
        return (price * numberOfNight) + getAdminFee(price * numberOfNight);
    }
}
