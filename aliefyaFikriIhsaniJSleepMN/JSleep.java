package aliefyaFikriIhsaniJSleepMN;


public class JSleep {
    
    public static void main (String[] args){
        
        Complaint testComplain = new Complaint(1,"23 August 2022","Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room (1,"Presidential Suite", 5 ,testPrice,
        Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
        
        
        
        
/*        
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2,2,2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print()); 
*/ 
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
