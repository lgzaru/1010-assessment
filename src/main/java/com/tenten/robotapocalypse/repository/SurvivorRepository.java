package com.tenten.robotapocalypse.repository;

import com.tenten.robotapocalypse.domain.SurvivorDto;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Created 24/02/2023 - 14:34
 * Project robotApocalypse
 * Author LG Zaru
 */
public interface SurvivorRepository extends JpaRepository <SurvivorDto, Long> {



}
