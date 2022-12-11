package com.aliefyaFikriIhsaniJSleepMN;

/**
 * Kelas ThreadingObject berfungsi sebagai kelas yang berisi fungsi-fungsi yang digunakan untuk mengatur thread
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */

public class ThreadingObject extends Thread{

    public ThreadingObject(String name){
        super(name);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}
