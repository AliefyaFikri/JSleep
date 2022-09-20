package aliefyaFikriIhsaniJSleepMN;


public class JSleep {
    public static void main (String[] args){
        
    }
    
    public static int getHotelId(){
        return 0;
    }
    
    public static String getHotelName(){
        return "hotel";
    }
    
    public static boolean isDiscount(){
        return true;
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount<afterDiscount){
            return 0.0f;
        }
        else {
            return (float) ((beforeDiscount-afterDiscount)/10.f) ;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage){
        if (discountPercentage > 100.0f){
            return 0;
        } else {
            return price - (int) (price * (discountPercentage/100.0f));
        }
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        return (int) (discountedPrice / ( 1.0f- (discountPercentage / 100.0f)));
    }
    
    public static float getAdminFeePercentage(){
        return 0.05f;

    }
    
    public static int getAdminFee(int price){
        return (int) (getAdminFeePercentage() * price);

    }
    
    public static int getTotalPrice(int price, int numberOfNight){
        return (price * numberOfNight) + getAdminFee(price * numberOfNight);
    }
}
