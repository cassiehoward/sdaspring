package com.sda.sdaspring.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "birds")
public class Bird extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "can_fly")
    private boolean canFly;
    private int weight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tracking_device_id", referencedColumnName = "id")
    @JsonManagedReference
    private TrackingDevice trackingDevice;

    @ManyToOne
    @JoinColumn(name = "nest_id", referencedColumnName = "id")
    @JsonManagedReference
    Nest nest;

    @ManyToMany
    @JoinTable(
            name = "birds_foods",
            joinColumns = @JoinColumn(name = "bird_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    @JsonManagedReference
    private List<Food> foods;

    public Bird() {
    }

    public Bird(String name, boolean canFly, int weight) {
        this.name = name;
        this.canFly = canFly;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public int getWeight() {
        return weight;
    }

    public TrackingDevice getTrackingDevice() {
        return trackingDevice;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setTrackingDevice(TrackingDevice trackingDevice) {
        this.trackingDevice = trackingDevice;
    }

    public Nest getNest() {
        return nest;
    }

    public void setNest(Nest nest) {
        this.nest = nest;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
