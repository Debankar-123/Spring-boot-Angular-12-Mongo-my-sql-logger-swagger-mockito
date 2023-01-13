package com.thryve;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan
@EnableEurekaClient
public class HealthCardModuleApplication {

	
	private static Logger logger= LogManager.getLogger(HealthCardModuleApplication.class);
	// static final String path ="C:\\Users\\91738\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\secondSTS4\\HealthCardModule\\src\\main\\resources\\log4j2.properties";
	public static void main(String[] args) {
		SpringApplication.run(HealthCardModuleApplication.class, args);
		// PropertyConfigurator.configure(path);
		logger.debug("main start1");
		logger.info("info");
		logger.debug("main start");
		logger.error("error");
		logger.warn("Warning");
		
		
	}
	

}
