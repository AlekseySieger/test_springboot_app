package com.car_sales_company.car_app.repository;


import com.car_sales_company.car_app.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
