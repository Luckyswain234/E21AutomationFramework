package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepositorty.CartPage;
import ObjectRepositorty.InventoryItemPage;
import ObjectRepositorty.LOginMethod;
import ObjectRepositorty.inventoryPage;
import genericUtility.BaseClass;
import genericUtility.FileUtility;
import genericUtility.SeleniumUtility;
@Listeners(genericUtility.ListenerImplimentationUtility.class)
public class AddProductToCartTest extends  BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws IOException
	{
	
//				Read the Test Data from Excel file
				String PRODUCTNAME = fUtil.readDataFromExcelFile("products", 1, 2);
				
								
				//Click on a product 
				 inventoryPage ip=new inventoryPage(driver);
				 ip.clickOnAProduct(driver, PRODUCTNAME);
				 
				 //Add product to cart
				 InventoryItemPage iip = new  InventoryItemPage(driver);
				 iip.clickOnAddcartBtn();
				 
				//Navigate to cart
				ip.clickONCartContainerBtn();
				
				//Validate for the product in cart
				CartPage cp = new CartPage(driver);
				
				String productInCart= cp.captrureItemName();
				Assert.assertEquals(productInCart, PRODUCTNAME);
				System.out.println(productInCart);

			}
	@Test
	public void sample()
	{
		System.out.println("demo");
	}

	

}
