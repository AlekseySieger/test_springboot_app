package com.car_sales_company.car_app.service;

import com.car_sales_company.car_app.domain.Car;
import com.car_sales_company.car_app.dto.CarDto;
import com.car_sales_company.car_app.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(CarDto carDto) {
        Car car = carDtoToCar(carDto);
        carRepository.save(car);
    }


    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public List<CarDto> getActiveList() {
        return carRepository.findAll().stream().filter(Car::getActive).map(this::carToCarDto).toList();
    }

    private CarDto carToCarDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setColor(car.getColor());
        carDto.setModel(car.getModel());
        carDto.setPrice(car.getPrice());
        carDto.setComplectation(car.getComplectation());
        carDto.setEnginePower(car.getEnginePower());
        carDto.setAcceleration(car.getAcceleration());
        carDto.setFuelConsumption(car.getFuelConsumption());
        carDto.setMaxSpeed(car.getMaxSpeed());
        carDto.setTypeOfFuel(car.getTypeOfFuel());
        return carDto;
    }

    private Car carDtoToCar(CarDto carDto) {
        Car car = new Car();
        car.setPrice(carDto.getPrice());
        car.setColor(carDto.getColor());
        car.setModel(carDto.getModel());
        car.setEnginePower(carDto.getEnginePower());
        car.setAcceleration(carDto.getAcceleration());
        car.setComplectation(carDto.getComplectation());
        car.setFuelConsumption(carDto.getFuelConsumption());
        car.setMaxSpeed(carDto.getMaxSpeed());
        car.setTypeOfFuel(carDto.getTypeOfFuel());
        car.setActive(true);
        return car;
    }


    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }


    public void setActiveFalse(Long id) {
        Car car = getById(id);
        car.setActive(false);
        carRepository.save(car);
    }

    public void setActiveTrue(Long id) {
        Car car = getById(id);
        car.setActive(true);
        carRepository.save(car);
    }

    public void update(Long id, CarDto carDto) {
        Car car = getById(id);
        if (carDto.getPrice() != null) {
            car.setPrice(carDto.getPrice());
        }
        if (carDto.getColor() != null) {
            car.setColor(carDto.getColor());
        }
        if (carDto.getEnginePower() != null) {
            car.setEnginePower(carDto.getEnginePower());
        }
        if (carDto.getFuelConsumption() != null) {
            car.setFuelConsumption(carDto.getFuelConsumption());
        }
        if (carDto.getAcceleration() != null) {
            car.setAcceleration(carDto.getAcceleration());
        }
        if (carDto.getMaxSpeed() != null) {
            car.setMaxSpeed(carDto.getMaxSpeed());
        }
        if (carDto.getComplectation() != null) {
            car.setComplectation(carDto.getComplectation());
        }
        if (carDto.getTypeOfFuel() != null) {
            car.setTypeOfFuel(carDto.getTypeOfFuel());
        }

        carRepository.save(car);
    }

    public List<String> findUniqueColor() {
        return carRepository.findUniqueColor();
    }

}
