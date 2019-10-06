package com.messaging.pulsar.pulsar.producer;

import java.util.stream.IntStream;

import org.apache.pulsar.client.api.CompressionType;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

	
	@Value("${pulsar.url}")
	private String pulsarURL;
	
	@Value("${pulsar.topic}")
	private String topic;
	
	
	
	
	public void produce() {
		
		try {
			PulsarClient client = PulsarClient.builder()
					  .serviceUrl(pulsarURL)
					  .build();
					 
					Producer<byte[]> producer = client.newProducer()
					  .topic(topic)
					  .compressionType(CompressionType.ZLIB)
					  .create();
					
					// Send 5 test messages
			        IntStream.range(1, 100).forEach(i -> {
			            String content = String.format("Message-%d", i);

			           // Send each message and log message content and ID when successfully received
			            try {
			                MessageId msgId = producer.send(content.getBytes());

			                System.out.println("Published message '"+content+"' with the ID "+msgId);
			            } catch (PulsarClientException e) {
			                System.out.println(e.getMessage());
			            }
			        });

			        client.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
