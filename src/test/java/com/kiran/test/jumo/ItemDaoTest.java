package com.kiran.test.jumo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kiran.test.jumo.daos.ItemRepository;

@DataJpaTest
public class ItemDaoTest {

	@Autowired
	ItemRepository repo;
	
	
	@Test
	public void findAllTest()
	{
		System.out.println("size "+repo.findAll().size());
	}
}
