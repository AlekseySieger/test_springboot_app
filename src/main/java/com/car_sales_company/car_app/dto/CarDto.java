package com.car_sales_company.car_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String model;

    private String color;

    private Long price;

    private Long enginePower;

    private Long fuelConsumption;

    private Long acceleration;

    private Long maxSpeed;

    private String complectation;

    private String typeOfFuel;


}
