package com.order.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.order.model")
@EnableJpaRepositories(basePackages = "com.order.repository")
@ComponentScan(basePackages = {"com.order.controller", "com.order.service", "com.order.process"})
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
}

/*
 * db.sql file is used to create database object. it is available at CLASSPATH level
 */
