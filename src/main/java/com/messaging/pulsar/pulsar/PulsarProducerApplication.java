package com.messaging.pulsar.pulsar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PulsarProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PulsarProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
