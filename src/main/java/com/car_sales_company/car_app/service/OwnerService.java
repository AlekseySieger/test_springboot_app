package com.car_sales_company.car_app.service;

import com.car_sales_company.car_app.domain.Owner;
import com.car_sales_company.car_app.dto.OwnerDto;
import com.car_sales_company.car_app.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    private Owner ownerDtoToOwner(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setAge(ownerDto.getAge());
        owner.setName(ownerDto.getName());
        owner.setSecondName(ownerDto.getSecondName());
        owner.setCar(ownerDto.getCar());
        return owner;
    }

    public void save(OwnerDto ownerDto) {
        Owner owner = ownerDtoToOwner(ownerDto);
        ownerRepository.save(owner);
    }

    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }

    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    private OwnerDto ownerToOwnerDto(Owner owner) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setAge(owner.getAge());
        ownerDto.setName(ownerDto.getName());
        ownerDto.setSecondName(owner.getSecondName());
        ownerDto.setCar(owner.getCar());
        return ownerDto;
    }


    public Owner getById(Long id) {
        return ownerRepository.findById(id).orElseThrow();
    }

    public List<String> findUniqueName() {
        return ownerRepository.findUniqueName();
    }


    public void update(Long id, OwnerDto ownerDto) {
        Owner owner = getById(id);
        if (ownerDto.getName() != null) {
            owner.setName(ownerDto.getName());
        }
        if (ownerDto.getAge() != 0) {
            owner.setAge(ownerDto.getAge());
        }
        if (ownerDto.getSecondName() != null) {
            owner.setSecondName(ownerDto.getSecondName());
        }
        if (ownerDto.getCar() != null) {
            owner.setCar(ownerDto.getCar());
        }

        ownerRepository.save(owner);

    }
}
