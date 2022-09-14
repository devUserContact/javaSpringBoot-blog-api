package com.api.bluehappyface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.api.bluehappyface.*"})
public class BluehappyfaceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluehappyfaceApiApplication.class, args);
	}
}
