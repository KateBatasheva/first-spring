package ru.geekbrains.katebatasheva.spring.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private String title;
    private int id;
    private int cost;


    public Product() {
    }

    public Product(String title, int id, int cost) {
        this.title = title;
        this.id = id;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
