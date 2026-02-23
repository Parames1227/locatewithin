package com.locatewithin.backend.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    private final ElasticsearchClient client;

    public IndexService(ElasticsearchClient client) {
        this.client = client;
    }

    public String createIndex() {

        try {

            CreateIndexResponse response = client.indices()
                    .create(c -> c
                            .index("places")
                    );

            return "Places index created";

        } catch (Exception e) {

            return "Index creation failed: " + e.getMessage();
        }
    }
}