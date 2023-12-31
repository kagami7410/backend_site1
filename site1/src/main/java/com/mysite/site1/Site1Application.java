package com.mysite.site1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Site1Application {
	private static final Logger logger = LogManager.getLogger(Site1Application.class);
	public static void main(String[] args) {
		for(int i = 0; i < 20; i++){
			logger.info(
					"Test"
			);
		}
		logger.trace("TRACE");
		logger.debug("DEBUG");

		logger.error("ERROR");


		SpringApplication.run(Site1Application.class, args);
	}

}
