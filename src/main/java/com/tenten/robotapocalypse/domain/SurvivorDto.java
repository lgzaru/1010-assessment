package com.tenten.robotapocalypse.domain;

import com.tenten.robotapocalypse.utils.InfectionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 * Created 24/02/2023 - 14:25
 * Project robotApocalypse
 * Author LG Zaru
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "survivor")
@Builder
public class SurvivorDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "survivor_seq")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "idnumber", nullable = false)
    private String idNumber;

    @Column(name = "latitude", nullable = false)
    private String latitude;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @Column(name = "water", nullable = false)
    private String water;

    @Column(name = "food", nullable = false)
    private Integer food;

    @Column(name = "medication", nullable = false)
    private String medication;

    @Column(name = "ammunition", nullable = false)
    private String ammunition;

    @Column(name = "flag_status", nullable = false)
    private String flagStatus = InfectionStatus.NOT_INFECTED.toString();

    @Column(name = "contamination_count", nullable = false)
    private int contaminationCount;

}
