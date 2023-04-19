package com.example.knimbus;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    private List<Prediction> data;

    public List<Prediction> getData() {
        return data;
    }

    public void setData(List<Prediction> data) {
        this.data = data;
    }
}
