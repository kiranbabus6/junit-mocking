package com.kiran.test.jumo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class )
class BusinessImplementationTest {

	@InjectMocks
	BusinessImplementation bi;
	@Mock
	DataService ds;
	
	@Test
	void calculateSumDatTest() {
		
		when(ds.retrieveAllData()).thenReturn(new int[] {1,2,3});
		bi.setDataService(ds);
		int result = bi.calculateSum();
		assertEquals(result, 6);
	}

	@Test
	void calculateSumEmptyTest() {
		when(ds.retrieveAllData()).thenReturn(new int[] {});
		bi.setDataService(ds);
		int result = bi.calculateSum();
		assertEquals(result, 0);
	}

	
}
