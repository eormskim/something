package com.example.something;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.something.board")
public class SomethingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomethingApplication.class, args);
	}

}
