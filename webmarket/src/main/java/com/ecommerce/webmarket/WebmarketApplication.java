package com.ecommerce.webmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
//@EnableJpaRepositories
@EnableJpaRepositories(basePackages="com.ecommerce.repository")
@EntityScan("com.*")
public class WebmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebmarketApplication.class, args);
	}

}
