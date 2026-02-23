package com.locatewithin.backend.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.locatewithin.backend.model.Place;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final ElasticsearchClient client;

    public DataService(ElasticsearchClient client) {
        this.client = client;
    }

    public String insertPlace(Place place) {

        try {

            client.index(i -> i
                    .index("places")
                    .id(place.getId())
                    .document(place)
            );

            return "Inserted Successfully: " + place.getName();

        } catch (Exception e) {

            e.printStackTrace();
            return "Insert failed: " + e.getMessage();
        }
    }
}