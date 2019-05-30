package com.netcracker.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "last_name", nullable = false)
    private String name;

    @Column(name = "living_area", nullable = false)
    private String livingArea;

    @Column(name = "sale", nullable = false)
    private Float sale;

    public Customer() {}

    public Customer(String name, String livingArea, Float sale) {
        this.name = name;
        this.livingArea = livingArea;
        this.sale = sale;
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

    public String getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public Float getSale() {
        return sale;
    }

    public void setSale(Float sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", livingArea='" + livingArea + '\'' +
                ", sale=" + sale +
                '}';
    }
}
