package com.example.bytefitjava.bytefit.repository;

import com.example.bytefitjava.bytefit.model.Foods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends MongoRepository<Foods, String> {

    List<Foods> findByFoodDesc(String foodDesc);
    List<Foods> findByCalories(int calories);

    @Override
    void deleteById(String s);
}
