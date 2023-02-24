package com.tenten.robotapocalypse.serviceImpl;

import com.tenten.robotapocalypse.domain.Robots;
import com.tenten.robotapocalypse.domain.SurvivorDto;

import java.util.List;
import java.util.Optional;

/*
 * Created 24/02/2023 - 14:37
 * Project robotApocalypse
 * Author LG Zaru
 */
public interface SurvivorService {
    SurvivorDto addSurvivor(SurvivorDto survivorDto);
    SurvivorDto updateSurvivor(Long survivorId, SurvivorDto survivorDto);
    SurvivorDto flagSurvivor (Long survivorId);
    SurvivorDto getSurvivorByID(Long survivorId);
    List<Robots> getAllRobotsAndLocations ();
    List<SurvivorDto> getAllSurvivors();

}
