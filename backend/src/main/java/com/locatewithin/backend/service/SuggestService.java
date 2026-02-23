package com.locatewithin.backend.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.locatewithin.backend.model.Place;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestService {

    private final ElasticsearchClient client;

    public SuggestService(ElasticsearchClient client) {
        this.client = client;
    }

    public List<String> suggest(String query) throws Exception {

        SearchResponse<Place> response = client.search(s -> s
                        .index("places")
                        .query(q -> q
                                .prefix(p -> p
                                        .field("name")
                                        .value(query.toLowerCase())
                                )
                        ),
                Place.class
        );

        return response.hits().hits()
                .stream()
                .map(hit -> hit.source().getName())
                .toList();
    }
}