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

}
