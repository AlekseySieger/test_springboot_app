package com.car_sales_company.car_app.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false, length = 256)
    private String color;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false,name = "engine_power")
    private Long enginePower;

    @Column(nullable = false, name = "fuel_consumption")
    private Long fuelConsumption;

    @Column(nullable = false)
    private Long acceleration;

    @Column(nullable = false, name = "max_speed")
    private Long maxSpeed;

    @Column(nullable = false)
    private String complectation;

    @Column(nullable = false, name = "type_of_fuel")
    private String typeOfFuel;

    private Boolean active;


}
