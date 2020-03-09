package com.example.bytefitjava.bytefit.controller;

import com.example.bytefitjava.bytefit.entity.Food;
import com.example.bytefitjava.bytefit.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/food")
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/food/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable(value = "id") String foodId) throws IllegalStateException {
        Food food =
                foodRepository
                        .findById(foodId)
                        .orElseThrow(() -> new IllegalStateException("Food not found on :: " + foodId));
        return ResponseEntity.ok().body(food);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/foods")
    public Food newFood(@RequestBody Food food) {
        //need to add some validation around input here
        foodRepository.save(food);
        log.info("'{}' has been inserted into the database.", food.getFoodDesc());
        return food;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/food/{id}")
    public void deleteFood(@PathVariable String id) {
        Optional<Food> food = foodRepository.findById(id);
        try {
            if (food.isPresent()) {
                log.info("'{}' is successfully deleted from the database", food.get().getFoodDesc());
                foodRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }
}
