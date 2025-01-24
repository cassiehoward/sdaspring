package com.sda.sdaspring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tracking_devices")
public class TrackingDevice extends BaseEntity {
    private String serialNumber;
    private LocalDate activationDate;

    @OneToOne(mappedBy = "trackingDevice")
    @JsonBackReference
    private Bird bird;

    public TrackingDevice() {

    }

    public TrackingDevice(String serialNumber, String activationDate) {
        this.serialNumber = serialNumber;
        this.activationDate = LocalDate.parse(activationDate);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public Bird getBird() {
        return bird;
    }
}
