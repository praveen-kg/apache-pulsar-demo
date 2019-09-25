package org.app.pulsar;

import org.app.pulsar.producer.PulsarProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PulsarApplication implements CommandLineRunner {

	@Autowired
	private PulsarProducer producer;
	
	public static void main(String[] args) {
        SpringApplication.run(PulsarApplication.class,args);
    }

	public void run(String... args) throws Exception {
		producer.produceMessage();
	}


}
