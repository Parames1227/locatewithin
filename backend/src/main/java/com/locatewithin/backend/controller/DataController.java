package com.locatewithin.backend.controller;

import com.locatewithin.backend.model.Place;
import com.locatewithin.backend.service.DataService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/insert-place")
    public String insertPlace(@RequestBody Place place) {

        return dataService.insertPlace(place);
    }
}