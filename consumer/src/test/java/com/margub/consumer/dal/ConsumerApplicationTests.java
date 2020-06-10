package com.margub.consumer.dal;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.margub.consumer.dal.entities.Consumer;
import com.margub.consumer.dal.repos.IConsumerRepository;

@SpringBootTest
class ConsumerApplicationTests {
//
//	@Autowired
//	IConsumerRepository consumerRepository;
//	
//	@Test
//	public void testCreateConsumer() {
//		
//		Consumer consumer = new Consumer();
//		
//		consumer.setEmail("faraz.alam@gmail.com");
//		
//		consumer.setName("Faraz");
//		
//		consumerRepository.save(consumer);
//		
//		
//	}
//	
//	
//	@Test 
//	public void testReadConsumer() {
//		
//		
//		Optional<Consumer> findById = consumerRepository.findById((long) 1d);
//		
//		Consumer consumer = findById.get();
//		
//		System.out.println(consumer.getEmail());
//		
//		
//	}
//	
//	@Test
//	
//	public void testUpdateConsumer() {
//		
//		Optional<Consumer> findById = consumerRepository.findById((long) 1d);
//		
//		Consumer consumer = findById.get();
//		
//		consumer.setName("Faraz Alam");
//
//		consumerRepository.save(consumer);
//		
//		
//	}
//	
//	@Test 
//	public void testDeleteConsumer() {
//		
//		Optional<Consumer> findById = consumerRepository.findById((long) 1d);
//		
//		Consumer consumer = findById.get();
//		
//		consumerRepository.delete(consumer);
//	}

}
