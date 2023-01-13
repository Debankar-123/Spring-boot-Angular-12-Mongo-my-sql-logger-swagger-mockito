package com.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthenticationApplication.class, args);
	}

}
