package com.kiran.test.jumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.test.jumo.service.ItemBusinessService;
import com.kiran.test.jumo.vos.ItemVo;

@RestController
public class ItemController {

	@Autowired
	ItemBusinessService bs;
	@GetMapping("/get-item")
	public ItemVo getItem()
	{
		return new ItemVo(1,"Ball",10,100);
	}
	
	@GetMapping("get-item-from-bs")
	public ItemVo getItemFromBs()
	{
		return bs.getItemFromBs();
	}
	
	@GetMapping("get-all-item-from-db")
		public List<ItemVo> getAllItemsFromDb()
		{
			return bs.retrieveAllItems();
		}
}
