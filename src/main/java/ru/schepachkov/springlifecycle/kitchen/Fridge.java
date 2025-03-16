package ru.schepachkov.springlifecycle.kitchen;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Fridge {

    private String name;
    private Product product;

    @Lookup
    public Product getProduct(){
        return null;
    }

    public Fridge(@Value("${vars.fridge.name}") String name, Product product) {
        this.name = name;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "name='" + name + '\'' +
                ", product=" + getProduct() +
                '}';
    }
}
