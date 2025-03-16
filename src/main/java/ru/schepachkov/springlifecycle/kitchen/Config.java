package ru.schepachkov.springlifecycle.kitchen;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.function.Supplier;

@Configuration
public class Config {

    private int productCounter;


    @Bean
    public Supplier<Product> productSupplier(ObjectFactory<Product> productFactory) {
        return productFactory::getObject;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Product product(@Value("${vars.product.commonName}") String name) {
        return new Product(name + "_" + productCounter++);
    }

    @Bean
    public Fridge fridge(@Value("${vars.fridge.name}") String name, Supplier<Product> productSupplier) {
        return new Fridge(name, productSupplier);
    }
}
