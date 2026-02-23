package com.locatewithin.backend.controller;

import com.locatewithin.backend.model.Place;
import com.locatewithin.backend.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public List<Place> search(@RequestParam String query) throws Exception {

        return searchService.search(query);
    }
}