package com.rnd.vertx;

import io.vertx.core.Vertx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@ComponentScan ( basePackages = {"com.rnd.vertx"} )
@EnableAutoConfiguration
public class Bootstrap {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Bootstrap.class, args);
		
	}

}
