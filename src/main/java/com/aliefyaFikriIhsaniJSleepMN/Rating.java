package com.aliefyaFikriIhsaniJSleepMN;

/**
 * Kelas Rating merupakan kelas yang berisi Rating dari sebuah room
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */
public class Rating
{
    private long total;
    private long count;

    /**
     * Constructor dari kelas Rating
     */
    public Rating(){
        total = 0;
        count = 0;
    }

    /**
     * Method Insert berfungsi untuk menambahkan rating dari sebuah room
     *
     */
    public void insert(int rating){
        total += rating;
        count++;
    }

    /**
     * Method getAverage berfungsi untuk mengembalikan rating rata-rata dari sebuah room
     */
    public double getAverage(){
        if (count == 0){
            return 0.0d;
        }
        return (double) total/count;
    }


    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }

    /**
     * Method toString berfungsi untuk menampilkan total dan count rating dari sebuah room
     */
    public String toString(){
        String print = "Total: " + total +
                   "\nCount: " + count ;
        return print;
    }
    
    
}
