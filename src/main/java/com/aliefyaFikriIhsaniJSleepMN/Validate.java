package com.aliefyaFikriIhsaniJSleepMN;
import java.util.ArrayList;

/**
 * Kelas Validate berfungsi sebagai kelas yang berisi fungsi-fungsi yang digunakan untuk memvalidasi inputan user
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */

public class Validate {
    public static ArrayList filter (Price[] list, int value, boolean less){
        ArrayList filteredPrice = new ArrayList();
        if(less == true) {
            for (Price iterator : list) {
                if(iterator.price <= value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        else{
            for (Price iterator : list) {
                if(iterator.price > value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        return filteredPrice;
    }
}