package com.netcracker.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "shops")
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location_area", nullable = false)
    private String locationArea;

    @Column(name = "commission", nullable = false)
    private Float commission;

    public Shop(){}

    public Shop(String name, String locationArea, Float commission) {
        this.name = name;
        this.locationArea = locationArea;
        this.commission = commission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(String locationArea) {
        this.locationArea = locationArea;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }
}
