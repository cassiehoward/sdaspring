package com.sda.sdaspring.services;

import com.sda.sdaspring.models.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAllFoods();

    Food getFoodById(long id);
}
