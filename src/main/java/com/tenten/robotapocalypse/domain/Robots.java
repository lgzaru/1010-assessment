package com.tenten.robotapocalypse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 * Created 24/02/2023 - 15:17
 * Project robotApocalypse
 * Author LG Zaru
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Robots {
    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "serialNumber", nullable = false)
    private String serialNumber;

    @Column(name = "manufacturedDate", nullable = false)
    private String manufacturedDate;

    @Column(name = "category", nullable = false)
    private String category;
}