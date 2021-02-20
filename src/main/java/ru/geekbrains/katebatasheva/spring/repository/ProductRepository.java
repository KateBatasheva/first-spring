package ru.geekbrains.katebatasheva.spring.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.geekbrains.katebatasheva.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
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
    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProduct(String tittle, int id, int cost) {
        products.add(new Product(tittle, id, cost));
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public void deleteProduct(int id) {
        products.removeIf(b -> b.getId() == id);
    }
    public int AVGcost() {
        int avg = 0;
        for (int i = 0; i < products.size(); i++) {
            avg += products.get(i).getCost();
        }
        avg /= products.size();
        return avg;
    }
    public void update(int id, int cost) {
        getProduct(id).setCost(cost);
    }
    public Product getProduct(int id) {
        return products.get(id);
    }

    public int amount() {
        return products.size();
    }
    public Product getProduct(String name) {
        for (Product p : products) {
            if (p.getTitle().equals(name)) {
                return p;
            }
        }
        throw new NoSuchElementException("Такого товара нет");
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
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
