package ru.geekbrains.katebatasheva.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.katebatasheva.spring.model.Product;
import ru.geekbrains.katebatasheva.spring.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public Product getProduct(String name) {
        return repository.getProduct(name);
    }

    public List<Product> getAllProducts() {
        return repository.getProducts();
    }

    public int AVGcost() {
        return repository.AVGcost();
    }

    public void deleteProduct(int id) {
        repository.deleteProduct(id);
    }

    public void addProduct(Product product) {
        repository.addProduct(product);
    }

    public void update(int id, int cost) {
        repository.update(id, cost);
    }


}
