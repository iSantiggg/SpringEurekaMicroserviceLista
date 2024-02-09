package com.init.products;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAutoConfiguration
@SpringBootApplication
@Configurable
@EnableEurekaClient
public class ListaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaApiApplication.class, args);
	}

}
