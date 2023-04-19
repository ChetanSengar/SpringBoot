package com.example.knimbus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Prediction {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("arrival_time")
    private String arrivalTime;
    
    @JsonProperty("departure_time")
    private String departureTime;
    
    @JsonProperty("direction_id")
    private int directionId;
    
    @JsonProperty("stop_sequence")
    private int stopSequence;
    
    @JsonProperty("route")
    private Route route;
    
    @JsonProperty("stop")
    private Stop stop;

    // Getters and Setters
}
