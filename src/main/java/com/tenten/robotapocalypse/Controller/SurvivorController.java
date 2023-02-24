package com.tenten.robotapocalypse.Controller;

import com.tenten.robotapocalypse.domain.Robots;
import com.tenten.robotapocalypse.domain.SurvivorDto;
import com.tenten.robotapocalypse.serviceImpl.SurvivorService;
import com.tenten.robotapocalypse.utils.InfectionStatus;
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

    @GetMapping("/percentageInfectedSurvivor")
    private double percentageInfectedSurvivor() {
        return survivorService.percentageInfectedSurvivor();
    }

    @GetMapping("/percentageNonInfectedSurvivor")
    private double percentageNonInfectedSurvivor() {
        return survivorService.percentageNonInfectedSurvivor();
    }

    @GetMapping("/allInfected")
    private List<SurvivorDto> allInfected() {
        List<SurvivorDto> totalSurvivors = survivorService.getAllSurvivors();
        List<SurvivorDto> infectedSurvivors = totalSurvivors.stream()
                .filter(infected -> infected.getFlagStatus().equals(InfectionStatus.INFECTED.name())).toList();
        return infectedSurvivors;
    }

    @GetMapping("/allNonInfected")
    private List<SurvivorDto> allNonInfected() {
        List<SurvivorDto> totalSurvivors = survivorService.getAllSurvivors();
        List<SurvivorDto> nonInfectedSurvivors = totalSurvivors.stream()
                .filter(infected -> infected.getFlagStatus().equals(InfectionStatus.NOT_INFECTED.name())).toList();
        return nonInfectedSurvivors;
    }



}
