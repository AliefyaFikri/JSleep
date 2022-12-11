package com.aliefyaFikriIhsaniJSleepMN;
import java.util.List;

import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonDBEngine;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kelas JSleep berfungsi sebagai kelas yang menjalankan program
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */
@SpringBootApplication
public class JSleep {

    public static void main (String[] args){

        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
}
}