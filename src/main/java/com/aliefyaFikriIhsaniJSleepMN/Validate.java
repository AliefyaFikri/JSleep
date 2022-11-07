package com.aliefyaFikriIhsaniJSleepMN;
import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
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