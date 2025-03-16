package ru.schepachkov.springlifecycle.kitchen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Fridge {

    private String name;
    private Supplier<Product> productSupplier;
    private Product currentProduct;
    private List<Product> products = new ArrayList<>();


    public Fridge(String name, Supplier<Product> productSupplier) {
        this.name = name;
        this.productSupplier = productSupplier;
        this.currentProduct = productSupplier.get();
        products.add(currentProduct);
    }

    public void takeAnotherProduct() {
        currentProduct = productSupplier.get();
        products.add(currentProduct);
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
