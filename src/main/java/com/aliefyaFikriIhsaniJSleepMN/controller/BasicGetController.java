package com.aliefyaFikriIhsaniJSleepMN.controller;

import com.aliefyaFikriIhsaniJSleepMN.Algorithm;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.Serializable;
import com.aliefyaFikriIhsaniJSleepMN.dbjson.JsonTable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface BasicGetController <T extends Serializable> {

    public abstract JsonTable<T> getJsonTable();

    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return getJsonTable().subList(page, page + pageSize);
    }

    public default T getById(@PathVariable int id) {
        return getJsonTable().get(id);
    }
}
