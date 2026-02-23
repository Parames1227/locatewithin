package com.locatewithin.backend.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.locatewithin.backend.model.Place;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimilarService {

    private final ElasticsearchClient client;

    public SimilarService(ElasticsearchClient client) {
        this.client = client;
    }

    public List<Place> similar(String category) throws Exception {

        SearchResponse<Place> response = client.search(s -> s
                        .index("places")
                        .query(q -> q
                                .match(m -> m
                                        .field("category")
                                        .query(category)
                                )
                        ),
                Place.class
        );

        return response.hits().hits()
                .stream()
                .map(hit -> hit.source())
                .toList();
    }
}