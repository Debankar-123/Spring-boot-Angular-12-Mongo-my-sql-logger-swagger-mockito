package com.example.demo;

//import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//@ComponentScan
public class PatientModule1Application {
//	private static Logger logger= LogManager.getLogger(PatientModule1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(PatientModule1Application.class, args);
		/*logger.debug("main start");
		logger.info("main start");
		logger.debug("main start1");
		logger.error("error");
		logger.warn("warning");*/
	}

}
