package com.sda.sdaspring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "nests")
public class Nest extends BaseEntity {

    private String name;
    private Integer capacity;

    private String material;


    @OneToMany(mappedBy = "nest")
    @JsonBackReference
    private List<Bird> birds = new ArrayList<>();

    public Nest() {
    }

    public Nest(String name, Integer capacity, String material) {
        this.name = name;
        this.capacity = capacity;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getMaterial() {
        return material;
    }

    public List<Bird> getBirds() {
        return birds;
    }
}
