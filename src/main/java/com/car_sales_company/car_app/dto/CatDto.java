package com.car_sales_company.car_app.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatDto {
    private String breed;

    private String name;

    private String color;

    private Double weightKg;

    private Long price;

    private String typeOfWool;

    private Long age;

    private String ownersNumber;
}
