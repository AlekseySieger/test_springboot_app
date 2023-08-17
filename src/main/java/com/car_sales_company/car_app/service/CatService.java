package com.car_sales_company.car_app.service;

import com.car_sales_company.car_app.domain.Cat;
import com.car_sales_company.car_app.dto.CatDto;
import com.car_sales_company.car_app.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void save(CatDto catDto) {
        Cat cat = catDtoToCat(catDto);
        catRepository.save(cat);
    }

    public void delete(Long id) {
        catRepository.deleteById(id);
    }

    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    public List<CatDto> getActiveList() {
        return catRepository.findAll().stream().filter(Cat::getActive).map(this::catToCatDto).toList();
    }

    private Cat catDtoToCat(CatDto catDto) {
        Cat cat = new Cat();
        cat.setName(catDto.getName());
        if (catDto.getBreed() == null) {
            cat.setBreed("mongrel");
        } else {
            cat.setBreed(catDto.getBreed());
        }
        cat.setPrice(catDto.getPrice());
        cat.setColor(catDto.getColor());
        cat.setWeightKg(catDto.getWeightKg());
        cat.setTypeOfWool(catDto.getTypeOfWool());
        cat.setAge(catDto.getAge());
        cat.setOwnersNumber(catDto.getOwnersNumber());
        cat.setActive(true);
        return cat;
    }

    private CatDto catToCatDto(Cat cat) {
        CatDto catDto = new CatDto();
        catDto.setName(cat.getName());
        catDto.setAge(cat.getAge());
        catDto.setBreed(cat.getBreed());
        catDto.setPrice(cat.getPrice());
        catDto.setColor(cat.getColor());
        catDto.setWeightKg(cat.getWeightKg());
        catDto.setTypeOfWool(cat.getTypeOfWool());
        catDto.setAge(cat.getAge());
        catDto.setOwnersNumber(cat.getOwnersNumber());
        return catDto;
    }

    public Cat getById(Long id) {
        return catRepository.findById(id).orElseThrow();
    }


    public void setActiveFalse(Long id) {
        Cat cat = getById(id);
        cat.setActive(false);
        catRepository.save(cat);
    }

    public void setActiveTrue(Long id) {
        Cat cat = getById(id);
        cat.setActive(true);
        catRepository.save(cat);
    }

    public void update(Long id, CatDto catDto) {
        Cat cat = getById(id);
        if (catDto.getPrice() != null) {
            cat.setPrice(catDto.getPrice());
        }
        if (catDto.getWeightKg() != null) {
            cat.setWeightKg(catDto.getWeightKg());
        }
        if (catDto.getBreed() != null) {
            cat.setBreed(catDto.getBreed());
        }
        if (catDto.getTypeOfWool() != null) {
            cat.setTypeOfWool(catDto.getTypeOfWool());
        }
        if (catDto.getColor() != null) {
            cat.setColor(catDto.getColor());
        }
        if (catDto.getOwnersNumber() != null) {
            cat.setOwnersNumber(catDto.getOwnersNumber());
        }
        if (catDto.getName() != null) {
            cat.setName(catDto.getName());
        }
        catRepository.save(cat);

    }

}
