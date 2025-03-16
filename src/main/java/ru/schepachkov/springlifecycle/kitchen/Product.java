package ru.schepachkov.springlifecycle.kitchen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Product {

    private static int counter = 0;

    private String name;


    public Product(@Value("${vars.product.commonName}") String name) {
        this.name = name + "_" + counter++;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
