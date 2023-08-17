package com.car_sales_company.car_app.controller;


import com.car_sales_company.car_app.domain.Cat;
import com.car_sales_company.car_app.dto.CatDto;
import com.car_sales_company.car_app.service.CatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/cat", produces = MediaType.APPLICATION_JSON_VALUE)
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping
    public void create(@RequestBody CatDto catDto) {
        catService.save(catDto);
    }

    @GetMapping("/{id}")
    public Cat getById(@PathVariable Long id) {
        return catService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        catService.delete(id);
    }

    @GetMapping("/list")
    public List<Cat> getAll() {
        return catService.getAll();
    }

    @GetMapping("/active")
    public List<CatDto> getActiveList() {
        return catService.getActiveList();
    }

    @PostMapping("/unavailable/{id}")
    public void activeFalse(@PathVariable Long id) {
        catService.setActiveFalse(id);
    }

    @PostMapping("/available/{id}")
    public void activeTrue(@PathVariable Long id) {
        catService.setActiveTrue(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody CatDto catDto) {
        catService.update(id, catDto);
    }


}
