package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{
    @Autowired
    private VegetableRepository vegetableRepository;

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable getById(Long id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(!vegetable.isPresent()) {
            throw new PlantException("Bu id yok gardaş", HttpStatus.BAD_REQUEST);
        }
        return vegetable.get();
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable deletedVegetable = vegetableRepository.getById(id);
        vegetableRepository.deleteById(id);
        return deletedVegetable;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}