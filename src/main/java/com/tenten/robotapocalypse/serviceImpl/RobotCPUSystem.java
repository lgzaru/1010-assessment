package com.tenten.robotapocalypse.serviceImpl;

import com.tenten.robotapocalypse.domain.Robots;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/*
 * Created 24/02/2023 - 15:20
 * Project robotApocalypse
 * Author LG Zaru
 */
@Service
public class RobotCPUSystem {
    private final Logger logger = LoggerFactory.getLogger(RobotCPUSystem.class);

    public List<Robots> getAllRobots() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String endPointUrl = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
        try {
            ResponseEntity<String> response = restTemplate.exchange(endPointUrl, HttpMethod.POST, entity, String.class);

            if (response.getStatusCode().equals(HttpStatus.OK)) {
                logger.info("Successfully connected to robot sytem");
                return (List<Robots>) response;
            } else logger.error("Failed to connect");
        } catch (Exception e) {
            logger.warn("Error occurred");
            logger.warn("Trace: " + e);
            throw new RuntimeException("Runtime exception occurred");
        }
        return null;
    }
}
