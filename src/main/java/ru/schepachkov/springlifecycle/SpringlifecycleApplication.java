package ru.schepachkov.springlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.schepachkov.springlifecycle.kitchen.Fridge;
import ru.schepachkov.springlifecycle.kitchen.Product;

@SpringBootApplication
public class SpringlifecycleApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringlifecycleApplication.class, args);


        System.out.println("===============END OF INIT===============\n\n");
        Fridge fridge1 = context.getBean("fridge", Fridge.class);
        System.out.println("I see in my hand - " + fridge1.getCurrentProduct());
        fridge1.takeAnotherProduct();
        System.out.println("I see in my hand - " + fridge1.getCurrentProduct());
        Product product1 = context.getBean("product", Product.class);
        System.out.println(fridge1);
        System.out.println(product1);
        System.out.println("\n======AWAIT======\n");
        Thread.sleep(3000);
        Product product2 = context.getBean("product", Product.class);
        System.out.println(product2);
    }

}
