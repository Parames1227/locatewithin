package com.locatewithin.backend.controller;

import com.locatewithin.backend.model.Place;
import com.locatewithin.backend.service.SimilarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimilarController {

    private final SimilarService service;

    public SimilarController(SimilarService service) {
        this.service = service;
    }

    @GetMapping("/similar")
    public List<Place> similar(@RequestParam String category) throws Exception {

        return service.similar(category);
    }
}