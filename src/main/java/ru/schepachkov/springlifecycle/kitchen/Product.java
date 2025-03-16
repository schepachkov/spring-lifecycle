package ru.schepachkov.springlifecycle.kitchen;

import ru.schepachkov.springlifecycle.kitchen.lifecycle.LifecycleMarker;

import javax.annotation.PostConstruct;

@LifecycleMarker
public class Product {

    private String name;

    public Product(String name) {
        this.name = name;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post construct on bean" + this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
