package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getFruitsAsc(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getFruit(@PathVariable Long id){
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getFruitsDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable saveFruit(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/{name}")
    public List<Vegetable> searchByName(@PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable deleteFruit(@PathVariable Long id){
        return vegetableService.delete(id);
    }
}