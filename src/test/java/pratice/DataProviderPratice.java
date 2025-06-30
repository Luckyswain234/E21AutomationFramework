package pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderPratice {
	
	@Test(dataProvider = "customerinfo")
	public void creatCustomer(String name ,int id)
	{
		//name id - run multiple times -different data
		//multiple customer in single execution
		System.out.println("The customer name is -->"+name);
		System.out.println("The customer id is-->"+id);
	}

//stock your data
	@DataProvider(name = "customerinfo" ) //row and columns
	public Object[][] getData()//// 4 set of data and each set has 2 info
	{
//		Object[][] data = new  Object[4][2];
	
//	//First data set
//	data[0][0] ="Lucky";
//	data[0][1] = 12;
//	
//	//Second data set
//		data[1][0] ="Lucy";
//		data[1][1] = 14;
//		
//		//Thired data set
//		data[2][0] ="Lipi";
//		data[2][1] = 16 ;
//		
//		
//		//Fourth data set
//		data[3][0] ="Lina";
//		data[3][1] = 18;
//		
//		return data ;
		Object[][] data = new  Object[3][2];
		//First data set
    	data[0][0] ="bapa";
	    data[0][1] = 12;
		
	  //First data set
    	data[1][0] ="mummmy";
	    data[1][1] = 12;
		
	  //First data set
    	data[2][0] ="dibya";
	    data[2][1] = 12;
	    return data;
		
		
	}


}

