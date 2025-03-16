package ru.schepachkov.springlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.schepachkov.springlifecycle.kitchen.Fridge;
import ru.schepachkov.springlifecycle.kitchen.Product;

@SpringBootApplication
public class SpringlifecycleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringlifecycleApplication.class, args);

		Fridge fidge1 = context.getBean("fridge", Fridge.class);
		Fridge fidge2 = context.getBean("fridge", Fridge.class);

		Product product1 = context.getBean("product", Product.class);
		Product product2 = context.getBean("product", Product.class);


		System.out.println(fidge1);
		System.out.println(fidge2);
		System.out.println(product1);
		System.out.println(product2);
	}

}
