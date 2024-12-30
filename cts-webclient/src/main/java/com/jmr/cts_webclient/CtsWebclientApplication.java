package com.jmr.cts_webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jmr.cts_webclient")
public class CtsWebclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtsWebclientApplication.class, args);
	}

}
