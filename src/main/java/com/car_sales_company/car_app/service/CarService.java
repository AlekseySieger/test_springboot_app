package com.car_sales_company.car_app.service;

import com.car_sales_company.car_app.domain.Car;
import com.car_sales_company.car_app.domain.Owner;
import com.car_sales_company.car_app.dto.CarDto;
import com.car_sales_company.car_app.repository.CarRepository;
import com.car_sales_company.car_app.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class CarService {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public CarService(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
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
        checkComplectation(carDto.getComplectation());
        car.setComplectation(carDto.getComplectation());
        car.setFuelConsumption(carDto.getFuelConsumption());
        car.setMaxSpeed(carDto.getMaxSpeed());
        car.setTypeOfFuel(carDto.getTypeOfFuel());

        Owner owner = ownerRepository.findById(carDto.getOwnerId()).orElseThrow();
        car.setOwner(owner);
        car.setActive(true);
        return car;
    }

    private void checkComplectation(String complectation) {
        if (carRepository.selectExists(complectation)) {
            Car car = carRepository.findCarByComplectation(complectation);
            if (car.getActive()) {
                throw new RuntimeException("this car complectation is already exist");
            } else {
                delete(car.getId());
            }
        }
    }

    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    public void changeTypeOfActive(Long id, Boolean active) {

        Car car = getById(id);
        car.setActive(active);
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
        if (carDto.getOwnerId()!=null){
            Owner owner = ownerRepository.findById(carDto.getOwnerId()).orElseThrow();
            car.setOwner(owner);
        }

        carRepository.save(car);
    }

    public List<String> findUniqueColor() {
        return carRepository.findUniqueColor();
    }

    public String getOwnerNameByCarId(Long carId){
        return getById(carId).getOwner().getName();
    }
}
