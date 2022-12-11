package com.aliefyaFikriIhsaniJSleepMN;

import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;

/** Kelas Complaint berfungsi sebagai kelas yang berisi data dari complaint
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */
public class Complaint extends Serializable {

    public String desc;
    public String date;
    
    public Complaint (int id, String date, String desc){
        super();
        this.date = date;
        this.desc = desc;
    }
    
    public String toString(){
        String print =
                   "\nDesc: " + desc +
                   "\nDate: " + date;
        return print;
    }
    
}
