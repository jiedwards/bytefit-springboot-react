package com.example.bytefitjava.bytefit.controller;

import com.example.bytefitjava.bytefit.model.Foods;
import com.example.bytefitjava.bytefit.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
