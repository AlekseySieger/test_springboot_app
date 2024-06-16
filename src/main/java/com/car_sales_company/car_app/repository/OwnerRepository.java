package com.car_sales_company.car_app.repository;

import com.car_sales_company.car_app.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query(value = "select distinct name from owner;" , nativeQuery = true)
    List<String> findUniqueName();

}

