package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.Algorithm;
import com.aliefyaFikriIhsaniJSleepMN.City;
import com.aliefyaFikriIhsaniJSleepMN.Facility;
import com.aliefyaFikriIhsaniJSleepMN.Room;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonAutowired;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Room")
public class RoomController implements BasicGetController<Room> {

    @JsonAutowired(value = Room.class, filepath = "C:\\Java\\OOP\\JSleep\\src\\aliefyaFikriIhsaniJSleepMN\\json\\room.json")
    public static JsonTable<Room> roomTable;

    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @PostMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, predicate -> predicate.accountId == id);

    }

    @PostMapping("create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
    ){
        if ( roomTable!= null){
            Room room = new Room(name, accountId, size, price, facility, city, address);
            roomTable.add(room);
            return room;
        }
        return null;
    }
}
