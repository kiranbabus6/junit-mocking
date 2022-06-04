package com.kiran.test.jumo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.kiran.test.jumo.service.ItemBusinessService;
import com.kiran.test.jumo.vos.ItemVo;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService bs;
	
	//@Test
	public void itemControllerBasic() throws Exception
	{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/get-item")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk() ).andReturn();
		
	}
	
	//@Test
	public void itemControllerWithService() throws Exception
	{
		when(bs.getItemFromBs() ).thenReturn(new ItemVo(1,"Ball",10,100));
		RequestBuilder request = MockMvcRequestBuilders
				.get("/get-item-from-bs")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk() ).andReturn();
		
	}
	
	@Test
	public void itemControllergetAll() throws Exception
	{
		when(bs.retrieveAllItems() ).thenReturn( Arrays.asList ( 
				new ItemVo(1,"Ball",10,100),
				new ItemVo(2,"Bat", 50, 25)));
		RequestBuilder request = MockMvcRequestBuilders
				.get("/get-all-item-from-db")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk() ).andReturn();
		
	}
	
}
