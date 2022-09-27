package aliefyaFikriIhsaniJSleepMN;


public class JSleep {
    
    public static void main (String[] args){
        
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2,2,2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print()); 
 
/*        Room test = createRoom();
        
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);        
 */       
    }
    
/*   public static Room createRoom(){
        Price price =  new Price (100000,5);
        Room room = new Room(210,"kamar hotel", 30, price, Facility.WiFi);
        return room;
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
*/
}
