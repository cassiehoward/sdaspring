package com.sda.sdaspring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "foods")
public class Food extends BaseEntity {
    private String name;
    private Integer calories;

    @ManyToMany(mappedBy = "foods")
    @JsonBackReference
    private List<Bird> birds;

    public Food() {
    }

    public Food(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public Integer getCalories() {
        return calories;
    }

    public List<Bird> getBirds() {
        return birds;
    }
}
