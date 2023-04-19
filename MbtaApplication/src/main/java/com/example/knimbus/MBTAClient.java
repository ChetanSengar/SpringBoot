package com.example.knimbus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MBTAClient {

    @Value("${mbta.api.url}")
    private String mbtaApiUrl;

    public ApiResponse getPredictions() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(mbtaApiUrl, ApiResponse.class);
    }
}
