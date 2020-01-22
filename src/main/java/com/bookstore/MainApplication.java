package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.doTimeConsumingTask();
        };
    }
}


/*
 * How To Delay Connection Acquisition As Needed (Hibernate 5.2.10)

Description: This is a Spring Boot example that exploits Hibernate 5.2.10 capability of delaying the connection acquisition as needed. Normally, a database connection is aquried immediately after calling a method annotated with @Transactional. If this method contains some time-consuming tasks before the first SQL statement then the connection is hold open for nothing. But, Hibernate 5.2.10 allows us to delay the connection acquisition as needed. This example rely on HikariCP as the default connection pool for Spring Boot.

Key points:

set spring.datasource.hikari.auto-commit=false in application.properties
set spring.jpa.properties.hibernate.connection.provider_disables_autocommit=true in application.properties
 * 
 */
