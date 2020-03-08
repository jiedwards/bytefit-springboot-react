package com.example.bytefitjava.bytefit.controller;

import com.example.bytefitjava.bytefit.model.Foods;
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
    private FoodRepository foodRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/foods")
    public List<Foods> getAllFoods() {
        return foodRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/foods/{id}")
    public ResponseEntity<Foods> getFoodsById(@PathVariable(value = "id") String foodId) throws IllegalStateException {
        Foods food =
                foodRepository
                        .findById(foodId)
                        .orElseThrow(() -> new IllegalStateException("Food not found on :: " + foodId));
        return ResponseEntity.ok().body(food);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/foods")
    public Foods newFood(@RequestBody Foods food) {
        //need to add some validation around input here
        foodRepository.save(food);
        log.info("'{}' has been inserted into the database.", food.getFoodDesc());
        return food;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/foods/{id}")
    public void deleteFood(@PathVariable String id) {
        Optional<Foods> food = foodRepository.findById(id);
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
