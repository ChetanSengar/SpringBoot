package com.example.knimbus;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MBTAService {
    private final String MBTA_API_URL = "https://api-v3.mbta.com/predictions/?filter[stop]=place-pktrm&sort=departure_time&include=route";

    public List<Prediction> getPredictions() {
        RestTemplate restTemplate = new RestTemplate();
        ApiResponse apiResponse = restTemplate.getForObject(MBTA_API_URL, ApiResponse.class);
        return apiResponse != null ? apiResponse.getData() : List.of();
    }
}
