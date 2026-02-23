package com.locatewithin.backend.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.locatewithin.backend.model.Place;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class LoadDataService {

    private final ElasticsearchClient client;

    public LoadDataService(ElasticsearchClient client) {
        this.client = client;
    }

    public String loadData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<Place> places =
                mapper.readValue(
                        new File("data/places.json"),
                        new TypeReference<List<Place>>() {}
                );

        for (Place place : places) {

            client.index(i -> i
                    .index("places")
                    .id(place.getId())
                    .document(place)
            );

        }

        return "Loaded " + places.size() + " places";
    }
}