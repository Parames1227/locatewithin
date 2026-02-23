package com.locatewithin.backend.controller;

import com.locatewithin.backend.service.LoadDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadDataController {

    private final LoadDataService service;

    public LoadDataController(LoadDataService service) {
        this.service = service;
    }

    @GetMapping("/load-data")
    public String loadData() throws Exception {

        return service.loadData();
    }
}