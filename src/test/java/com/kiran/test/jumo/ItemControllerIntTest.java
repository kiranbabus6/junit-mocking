package com.kiran.test.jumo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIntTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads()
	{
		String response =  this.restTemplate.getForObject("/get-all-item-from-db", String.class);
		assertNotNull(response);
	}
	
}
