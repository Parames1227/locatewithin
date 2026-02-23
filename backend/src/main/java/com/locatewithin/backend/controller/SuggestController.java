package com.locatewithin.backend.controller;

import com.locatewithin.backend.service.SuggestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuggestController {

    private final SuggestService service;

    public SuggestController(SuggestService service) {
        this.service = service;
    }

    @GetMapping("/suggest")
    public List<String> suggest(@RequestParam String q) throws Exception {

        return service.suggest(q);
    }
}