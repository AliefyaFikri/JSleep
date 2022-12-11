package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.Algorithm;
import com.aliefyaFikriIhsaniJSleepMN.Predicate;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Kelas BasicGetController merupakan kelas yang berfungsi untuk
 * meminta value dari id dan page
 *
 * @author Aliefya Fikri Ihsani
 * @version 1.0
 */

public interface BasicGetController <T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();

    /**
     * Method get merupakan method yang berfungsi untuk mengambil value id
     *
     * @param id merupakan id dari data yang akan diambil
     */
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        final Predicate<T> idFilter = pred -> (id == pred.id);
        return Algorithm.find(getJsonTable(), idFilter);
    }

    /**
     * Method getAll merupakan method yang berfungsi untuk mengambil value dari page
     *
     * @param page merupakan page dari data yang akan diambil
     */
    @GetMapping(value ="/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}
