package com.kiran.test.jumo;

public class BusinessImplementation {

	private DataService dataService;
	
	public int calculateSum()
	{
		int sum=0;
		int[] data = dataService.retrieveAllData();
		for(int i : data)
			sum+=i;
		return sum;
	}

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	
}
