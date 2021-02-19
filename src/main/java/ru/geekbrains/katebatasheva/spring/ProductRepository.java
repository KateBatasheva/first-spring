package ru.geekbrains.katebatasheva.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Primary
public class ProductRepository {

    private List<Product> products;
    private static final int SIZE_LIST = 10;

    @PostConstruct
    public void init() {
        String[] fruits = {"Apple", "Peach", "Orange", "Kiwi", "Pear", "Strawberry", "Blueberry", "Lemon", "Melon", "Cherry"};
        Random random = new Random();
        products = new ArrayList<>();
        for (int i = 0; i < SIZE_LIST; i++) {
            products.add(new Product(fruits[i], i + 1, random.nextInt(10) + 10));
        }
    }


    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product p: products) {
            sb.append(p.getId()).append(" ").append(p.getTitle()).append(" - ").append(p.getCost()).append("\n");
        }
        return sb.toString();
    }
}
