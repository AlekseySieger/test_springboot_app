package com.car_sales_company.car_app.controller;

import com.car_sales_company.car_app.domain.Owner;
import com.car_sales_company.car_app.dto.OwnerDto;
import com.car_sales_company.car_app.service.OwnerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/owner", produces = MediaType.APPLICATION_JSON_VALUE)
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public void create(@RequestBody OwnerDto ownerDto){
        ownerService.save(ownerDto);
    }

    @GetMapping("/{id}")
    public Owner getById(@PathVariable Long id) {
        return ownerService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ownerService.delete(id);
    }


    @GetMapping("/list")
    public List<Owner> getAll() {
        return ownerService.getAll();
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody OwnerDto carDto) {
        ownerService.update(id, carDto);
    }

    @GetMapping("/unigue_name")
    public List<String> findUniqueName(){
        return ownerService.findUniqueName();
    }

}