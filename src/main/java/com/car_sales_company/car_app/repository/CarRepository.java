package com.car_sales_company.car_app.repository;

import com.car_sales_company.car_app.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "select distinct  color from car;", nativeQuery = true)
    List<String> findUniqueColor();

    Boolean existsByComplectation(String complectation);

    @Query(value = "select exists (select * from car where car.complectation = :complectation);", nativeQuery = true)
    Boolean selectExists(String complectation);

    Car findByComplectation(String complectation);

    @Query(value = "select * from car where car.complectation = :complectation;", nativeQuery = true)
    Car findCarByComplectation(String complectation);
}
