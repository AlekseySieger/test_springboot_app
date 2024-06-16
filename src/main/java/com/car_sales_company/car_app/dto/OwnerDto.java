package com.car_sales_company.car_app.dto;

import com.car_sales_company.car_app.domain.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {

    private String name;

    private String secondName;

    private short age;

    private List<Car> car;
}
