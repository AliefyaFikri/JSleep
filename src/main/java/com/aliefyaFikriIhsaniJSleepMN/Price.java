package com.aliefyaFikriIhsaniJSleepMN;

public class Price
{   
    public double price;
    //public double rebate;
    public double discount;
    
    public Price(double price)
    {
        this.price = price;
        this.discount = 0.0d;
        //this.rebate = 0.0d;
    }
    
    public Price(double price, double discount)
    {
        this.price = price;
        this.discount = discount;
        //this.rebate = 0.0d;
    }
    
    public String toString(){ 
        String print = "Price: " + price +
                   "\nDiscount: " + discount;
        return print;
    }
    
    /*public Price(double price, double rebate)
    {
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    private double getDiscountedPrice(){
        if (discount > 100){
            discount = 100;
        }
        if (discount == 100){
            return 0.0d;
        }else{
            return price-(price*discount/100);
        }
    }
    
    private double getRebatedPrice(){
        if (rebate > price){
            return price;
        } else {
            return getDiscountedPrice()*rebate;
        }
    }*/
}
