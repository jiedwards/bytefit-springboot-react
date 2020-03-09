package com.example.bytefitjava.bytefit.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foods")
@Data
public class Food {

    private String id;
    private String foodDesc;
    private Integer calories;
    private Double carbs;
    private Double fats;
    private Double protein;
    private String unitOptionOneDesc;
    private Double unitOptionOneMeasurement;
    private String unitOptionTwoDesc;
    private Double unitOptionTwoMeasurement;
    private Double totalSugar;
    private Double fiber;
    private Double calcium;
    private Double iron;
    private Double magnesium;
    private Double phosphorus;
    private Double potassium;
    private Double sodium;
    private Double zinc;
    private Double copper;
    private Double manganese;
    private Double selenium;
    private Double vitaminC;
    private Double vitaminB6;
    private Double vitaminB12;
    private Double vitaminA;
    private Double vitaminE;
    private Double vitaminD;
    private Double vitaminK;
    private Double cholesterol;
    private Boolean siteVisibility;
    private String userId;

    public Food(String foodDesc, Integer calories, Double carbs, Double fats, Double protein){
        this.foodDesc = foodDesc;
        this.calories = calories;
        this.carbs = carbs;
        this.fats = fats;
        this.protein = protein;
    }
}
