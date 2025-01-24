package com.sda.sdaspring.models.dtos;

public class BirdDTO {

    private String name;
    private boolean canFly;
    private int weight;

    // Default constructor
    public BirdDTO() {
    }

    // Constructor with parameters
    public BirdDTO(String name, boolean canFly, int weight) {
        this.name = name;
        this.canFly = canFly;
        this.weight = weight;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
