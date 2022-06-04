package com.kiran.test.jumo.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.test.jumo.daos.ItemRepository;
import com.kiran.test.jumo.vos.ItemVo;

@Service
public class ItemBusinessService {
	private Logger logger = LoggerFactory.getLogger(ItemBusinessService.class);

	@Autowired
	private ItemRepository repo;
	
	public ItemVo getItemFromBs()
	{
		return new ItemVo(1,"Ball",10,100);
	}
	
	public List<ItemVo> retrieveAllItems()
	{
		List<ItemVo> itemList = repo.findAll();
		for(ItemVo item : itemList)
			item.setValue(item.getPrice()*item.getQuantity()); 
	/*	itemList.stream().map(item -> {
			new ItemVo(item.getId(), item.getName(), item.getPrice(), item.getQuantity()) ;			
		}).collect(Collectors.toList()) ; */
		return itemList;
		
	}
}
