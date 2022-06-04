package com.kiran.test.jumo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import com.kiran.test.jumo.daos.ItemRepository;
import com.kiran.test.jumo.service.ItemBusinessService;
import com.kiran.test.jumo.vos.ItemVo;
@ExtendWith(MockitoExtension.class )
public class ItemBusinessTest {

	@InjectMocks
	ItemBusinessService ibs;
	@Mock
	private ItemRepository repo;
	
	@Test
	void retrieveAllItemsTest() {
		
		when(repo.findAll() ).thenReturn(
				Arrays.asList ( 
						new ItemVo(1,"Ball",10,100),
						new ItemVo(2,"Bat", 50, 25))
				);
		 List<ItemVo> itemList = ibs.retrieveAllItems();
		 assertNotNull(itemList);
		 assertEquals(itemList.get(0).getValue(), 1000);
	}
	
	
	
}
