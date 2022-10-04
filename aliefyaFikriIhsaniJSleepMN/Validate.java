package aliefyaFikriIhsaniJSleepMN;
import java.util.ArrayList;
import java.util.*;


/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validate
{
    
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList<Price> unfilteredArray = new ArrayList<Price> (Arrays.asList(list));
        ArrayList filteredArray = new ArrayList ();
        
        for (int i=0; i<unfilteredArray.size(); i++){
            if (less == true){
                if (unfilteredArray.get(i).price <= value){
                    filteredArray.add(unfilteredArray.get(i).price);
                }
            }else{
                if (unfilteredArray.get(i).price > value){
                    filteredArray.add(unfilteredArray.get(i).price);
                }
            }
        }
        return filteredArray;
    }
}