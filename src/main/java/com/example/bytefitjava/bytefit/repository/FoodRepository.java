package com.example.bytefitjava.bytefit.repository;

import com.example.bytefitjava.bytefit.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends MongoRepository<Food, String> {

    List<Food> findByFoodDesc(String foodDesc);
    List<Food> findByCalories(int calories);

    @Override
    void deleteById(String s);
}
