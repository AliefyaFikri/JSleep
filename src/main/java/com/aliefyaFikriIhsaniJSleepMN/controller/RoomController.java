package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.*;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Kelas RoomController merupakan kelas yang berfungsi untuk membuat room, mencari room dengan renter, dan memanggil semua room
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    @JsonAutowired(value = Room.class, filepath = "C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\room.json")
    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable getJsonTable() {
        return roomTable;
    }

    /**
     * Method getRoomByRenter merupakan method yang berfungsi untuk mencari room dengan renter
     *
     * @param id merupakan id dari renter
     * @param page merupakan halaman dari room
     * @param pageSize merupakan ukuran halaman dari room
     * @return
     */

    @PostMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, predicate -> predicate.accountId == id);

    }

    /**
     * Method create merupakan method yang berfungsi untuk membuat room
     *
     * @param accountId merupakan id dari account
     * @param name merupakan nama dari room
     * @param size merupakan ukuran dari room
     * @param price merupakan harga dari room
     * @param facility merupakan fasilitas yang dimiliki room
     * @param city merupakan kota tempat room berada
     * @param address merupakan alamat dari room
     * @param bedType merupakan jenis tempat tidur dari room
     */

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam double price,
            @RequestParam Facility[] facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
            Price price1 = new Price(price);
            Room room = new Room(accountId, name, size, price1, facility, city, address, bedType);
            roomTable.add(room);
            return room;
    }

    /** Method getAllRoom merupakan method yang berfungsi untuk memanggil semua room
     *
     * @param page merupakan halaman dari room
     * @param pageSize merupakan ukuran halaman dari room
     */

    @GetMapping("/getAllRoom")
    List<Room> getAllRoom
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> (true));
    }
}
