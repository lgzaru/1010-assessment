package com.tenten.robotapocalypse.Controller;

import com.tenten.robotapocalypse.domain.Robots;
import com.tenten.robotapocalypse.domain.SurvivorDto;
import com.tenten.robotapocalypse.serviceImpl.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Created 24/02/2023 - 16:02
 * Project robotApocalypse
 * Author LG Zaru
 */
@RestController
@RequestMapping("/api/survivor")
@CrossOrigin
public class SurvivorController {

    final SurvivorService survivorService;

    @Autowired
    public SurvivorController(SurvivorService survivorService) {
        this.survivorService = survivorService;
    }

    @PostMapping("/addSurvivor")
    private SurvivorDto addSurvivor(@RequestBody SurvivorDto survivorDto) {
        return survivorService.addSurvivor(survivorDto);
    }

    @PutMapping("/updateSurvivor/{survivorID}")
    private SurvivorDto updateSurvivor(@PathVariable Long survivorID, @RequestBody SurvivorDto survivorDto) {
        return survivorService.updateSurvivor(survivorID, survivorDto);
    }

    @GetMapping("/getAllSurvivors")
    private List<SurvivorDto> getAllSurvivors() {
        return survivorService.getAllSurvivors();
    }

    @PostMapping("/flagSurvivor/{survivorID}")
    private SurvivorDto flagSurvivor(@PathVariable Long survivorID) {
        return survivorService.flagSurvivor(survivorID);
    }

    @GetMapping("/getSurvivorById/{survivorID}")
    private SurvivorDto getSurvivorById(@PathVariable Long survivorID) {
        return survivorService.getSurvivorByID(survivorID);
    }

    @GetMapping("/getAllRobots")
    private List<Robots> getAllRobots() {
        return survivorService.getAllRobotsAndLocations();
    }


}
