package com.example.soapserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapServerApplication.class, args);
    }
    /*
        @Bean
        public CommandLineRunner loadData(ProductRepository productRepository) {
            return (args) -> {
                productRepository.save(new Product(1, "Table", 300.00, new Date()));
                productRepository.save(new Product(2, "Pen", 2.50, new Date()));
                productRepository.save(new Product(3, "Paint", 200.00, new Date()));
                productRepository.save(new Product(4, "Book", 5.00, new Date()));
                productRepository.save(new Product(5, "Glasses", 800.00, new Date()));
            };
        }

     */
    }


