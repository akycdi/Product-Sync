package com.productSync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class ProductSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSyncApplication.class, args);
		}
}
