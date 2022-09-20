package aliefyaFikriIhsaniJSleepMN;

public class Price
{   
    public double price;
    public double discount;
    public int rebate;
    
    public Price (double price){
        this.price = price;
    }

    public Price (double price, double discount)
    {
        this.price = price;
        this.discount = discount;
    }

    public Price (double price, int rebate){
        this.price = price;
        this.rebate = rebate;
    }
    
    private double getDiscountedPrice(){
        if (discount > 100.0d){
            return discount = 100.0d;
        } else if (discount == 100.0d) {
            return 0;
        } else {
            return (price - (price*discount/100.0d));
        }
    }
    
    private double getRebatedPrice(){
        if (rebate > price){
            return rebate = (int) price;
        } else {
            return price-rebate;
        }
    }
}
