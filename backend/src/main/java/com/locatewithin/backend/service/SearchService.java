package com.locatewithin.backend.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.locatewithin.backend.model.Place;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ElasticsearchClient client;

    public SearchService(ElasticsearchClient client) {
        this.client = client;
    }

    public List<Place> search(String query) throws Exception {

        SearchResponse<Place> response = client.search(s -> s
                        .index("places")
                        .query(q -> q
                                .match(m -> m
                                        .field("description")
                                        .query(query)
                                )
                        ),
                Place.class
        );

        return response.hits().hits().stream()
                .map(hit -> hit.source())
                .collect(Collectors.toList());
    }
}