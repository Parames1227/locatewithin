package com.locatewithin.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    private String id;
    private String name;
    private String description;
    private String category;
    private String city;

}