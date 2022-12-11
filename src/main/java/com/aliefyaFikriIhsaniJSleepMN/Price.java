package com.aliefyaFikriIhsaniJSleepMN;

/** Kelas Price berfungsi sebagai kelas yang berisi harga, discount, dan harga final dari sebuah room
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */
public class Price
{   
    public double price;
    //public double rebate;
    public double discount;

    /** Constructor dari kelas Price
     *
     * @param price harga dari sebuah room
     */
    public Price(double price)
    {
        this.price = price;
        this.discount = 0.0d;
        //this.rebate = 0.0d;
    }

    /** Method Price berfungsi untuk mengembalikan harga dari sebuah room
     *
     */
    public Price(double price, double discount)
    {
        this.price = price;
        this.discount = discount;
        //this.rebate = 0.0d;
    }

    /** Method toString berfungsi untuk mengembalikan price dan discount dari sebuah room
     *
     */
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
