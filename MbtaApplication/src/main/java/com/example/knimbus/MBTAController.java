package com.example.knimbus;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MBTAController {
    @Autowired
    private MBTAService mbtaService;

    @GetMapping("/predictions")
    public List<Prediction> getPredictions() {
        return mbtaService.getPredictions();
    }
}
