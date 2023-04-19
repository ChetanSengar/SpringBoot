package com.example.knimbus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("route_name")
    private String routeName;
    
    @JsonProperty("route_type")
    private int routeType;

    // Getters and Setters
}
