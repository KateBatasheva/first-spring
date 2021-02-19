package ru.geekbrains.katebatasheva.spring;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProductService {
   private ProductRepository repository;
   private List<Product> products;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
        this.products = repository.getProducts();

    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public Product getProduct (String name){
        for (Product p: products) {
            if (p.getTitle().equals(name)){
                return p;
            }
        }
        throw new NoSuchElementException("Такого товара нет");
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
        products.remove(id);
    }

    public void update(int id, int cost) {
        getProduct(id).setCost(cost);
    }

    public int amount (){
        return products.size();
    }

    public int AVGcost (){
        int avg =0;
        for (int i = 0; i <products.size() ; i++) {
            avg += products.get(i).getCost();
        }
        avg/=products.size();
        return avg;
    }

}
