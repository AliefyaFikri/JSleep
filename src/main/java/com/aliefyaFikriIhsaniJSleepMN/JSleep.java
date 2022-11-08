package com.aliefyaFikriIhsaniJSleepMN;
import java.util.List;

import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonDBEngine;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JSleep {
/*    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }
*/


/*    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
        }


    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        return Algorithm.<Room>collect(list,room -> room.price.price >= minPrice && room.price.price <= maxPrice);
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.<Room>paginate(list,page,pageSize,room -> room.accountId == accountId);
    }

 */
    public static void main (String[] args){
       SpringApplication.run(JSleep.class, args);
                Gson gson = new Gson();
/*     try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: "+ input.name);
            System.out.println("population: "+input.population);
            System.out.println("states: ");
            input.listOfStates.forEach(state -> System.out.println(state));
        }
        catch (IOException e){
            e.printStackTrace();
        }


        Renter testRegex = new Renter("Netlab_", "089535975704", "Jl Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        try{
            String filepath="C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\randomRoomList.json";
            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0,5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
*/
       Account testRegex = new Account("Aliefya Fikri Ihsani","faliefya@gmail.com", "Aliefya123");
        Account testRegexFail =new Account("Aliefya","alief-ya@gmail.com", "aliefya2");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        try{
            String filepath="C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\account.json";
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name","email","password"));
            tableAccount.writeJson();
            tableAccount.forEach(Account-> System.out.println(tableAccount.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }

        for(int i = 0; i < 10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }


        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
}
}