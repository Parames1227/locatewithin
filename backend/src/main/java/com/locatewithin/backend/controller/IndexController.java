package com.locatewithin.backend.controller;

import com.locatewithin.backend.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/create-index")
    public String createIndex() {

        return indexService.createIndex();
    }
}