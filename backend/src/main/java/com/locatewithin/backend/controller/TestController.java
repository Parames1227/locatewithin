package com.locatewithin.backend.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ElasticsearchClient client;

    public TestController(ElasticsearchClient client) {
        this.client = client;
    }

    @GetMapping("/test-elastic")
    public String testElastic() throws Exception {

        client.info();

        return "Elasticsearch Connected Successfully";
    }
}