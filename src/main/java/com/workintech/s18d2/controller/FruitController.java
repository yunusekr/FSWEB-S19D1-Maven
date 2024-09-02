package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getFruitsAsc(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getFruit(@PathVariable Long id){
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitsDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit saveFruit(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit deleteFruit(@PathVariable Long id){
        return fruitService.delete(id);
    }
}