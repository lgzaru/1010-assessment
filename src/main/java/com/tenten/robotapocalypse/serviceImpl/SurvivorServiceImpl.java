package com.tenten.robotapocalypse.serviceImpl;

import com.tenten.robotapocalypse.domain.Robots;
import com.tenten.robotapocalypse.domain.SurvivorDto;
import com.tenten.robotapocalypse.repository.SurvivorRepository;
import com.tenten.robotapocalypse.utils.InfectionStatus;
import com.tenten.robotapocalypse.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created 24/02/2023 - 14:37
 * Project robotApocalypse
 * Author LG Zaru
 */
@Service
public class SurvivorServiceImpl implements SurvivorService {
    //  final Logger logger = LoggerFactory.getLogger(SurvivorServiceImpl.class);
    private final SurvivorRepository survivorRepository;
    private final RobotCPUSystem robotCPUSystem;

    @Autowired
    public SurvivorServiceImpl(SurvivorRepository survivorRepository, RobotCPUSystem robotCPUSystem) {
        this.survivorRepository = survivorRepository;
        this.robotCPUSystem = robotCPUSystem;
    }

    @Override
    public SurvivorDto getSurvivorByID(Long survivorId) throws ResourceNotFoundException {
        return survivorRepository.findById(survivorId).orElseThrow(() -> new ResourceNotFoundException("Not Found" + survivorId));
    }

    @Override
    public SurvivorDto addSurvivor(SurvivorDto survivorDto) {
        return survivorRepository.save(survivorDto);
    }

    @Override
    public SurvivorDto updateSurvivor(Long survivorId,  SurvivorDto survivorDto) {
        SurvivorDto dbDto = survivorRepository.getById(survivorId);
        dbDto.setLatitude(survivorDto.getLatitude());
        dbDto.setLongitude(survivorDto.getLongitude());
        return survivorRepository.save(dbDto);
    }

    @Override
    public SurvivorDto flagSurvivor(Long survivorId) {
        SurvivorDto dbDto = survivorRepository.getById(survivorId);
        int count = dbDto.getContaminationCount() + 1;
        dbDto.setContaminationCount(count);
        if (count >= 3) {
            dbDto.setFlagStatus(InfectionStatus.INFECTED.toString());
        }
        return survivorRepository.save(dbDto);
    }

    @Override
    public List<Robots> getAllRobotsAndLocations() {
        return robotCPUSystem.getAllRobots();
    }


    @Override
    public List<SurvivorDto> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    @Override
    public double percentageInfectedSurvivor() {
        List<SurvivorDto> totalSurvivors = getAllSurvivors();
        List<SurvivorDto> infectedSurvivors = totalSurvivors.stream()
                .filter(infected -> infected.getFlagStatus().equals(InfectionStatus.INFECTED.name())).toList();
        return infectedSurvivors.size() * 100 / totalSurvivors.size();
    }
    @Override
    public double percentageNonInfectedSurvivor() {
        List<SurvivorDto> totalSurvivors = getAllSurvivors();
        List<SurvivorDto> infectedSurvivors = totalSurvivors.stream()
                .filter(infected -> infected.getFlagStatus().equals(InfectionStatus.NOT_INFECTED.name())).toList();
        return infectedSurvivors.size() * 100 / totalSurvivors.size();
    }


}
