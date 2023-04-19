package com.example.knimbus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stop {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("platform_code")
    private String platformCode;

    // Getters and Setters
}
