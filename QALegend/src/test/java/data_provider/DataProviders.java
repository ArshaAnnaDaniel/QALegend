package data_provider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="InvalidUserCredentials")
	public Object[][] userCredentialsData() {
		Object  data[][]= new String[3][2];
		
		data[0][0]="admim";
		data[0][1]="123456";
		
		data[1][0]="admin";
		data[1][1]="123459";
		
		data[2][0]="admio";
		data[2][1]="123456";
		
		return data;
	}

}
