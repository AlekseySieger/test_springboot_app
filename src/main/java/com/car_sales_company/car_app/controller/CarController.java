package com.car_sales_company.car_app.controller;

import com.car_sales_company.car_app.domain.Car;
import com.car_sales_company.car_app.dto.CarDto;
import com.car_sales_company.car_app.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void create(@RequestBody CarDto carDto) {
        carService.save(carDto);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

    @GetMapping("/list")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/active")
    public List<CarDto> getActiveList() {
        return carService.getActiveList();
    }

    @PostMapping("/unavailable/{id}")
    public void activeFalse(@PathVariable Long id) {
        carService.setActiveFalse(id);
    }

    @PostMapping("/available/{id}")
    public void activeTrue(@PathVariable Long id) {
        carService.setActiveTrue(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody CarDto carDto) {
        carService.update(id, carDto);
    }

    @GetMapping("/colors")
    public List<String> findUniqueColor(){
        return carService.findUniqueColor();
    }

}

