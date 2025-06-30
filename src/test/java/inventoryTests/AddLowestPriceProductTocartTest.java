package inventoryTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepositorty.CartPage;
import ObjectRepositorty.InventoryItemPage;
import ObjectRepositorty.inventoryPage;
import genericUtility.BaseClass;
@Listeners(genericUtility.ListenerImplimentationUtility.class)
public class AddLowestPriceProductTocartTest extends BaseClass
{
	@Test(groups = {"RegressionSuite","SmokeSuite"})
	
	public void tc_002_AddLowestPriceProductTocartTest() throws IOException
	{
				   	// Read the Test Data from Excel file
					String SORTOPTION = fUtil.readDataFromExcelFile("Products", 4, 2);
					String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 3);


					// Click on a Product
					inventoryPage ip = new inventoryPage(driver);
					ip.clickOnLowestPriceProduct(driver,SORTOPTION,PRODUCTNAME);

					// Add Product to Cart
					InventoryItemPage iip = new InventoryItemPage(driver);
					iip.clickOnAddcartBtn();

					// Navigate to Cart
					ip.clickONCartContainerBtn();

					// Validate for the product in Cart
					CartPage cp = new CartPage(driver);
					String productInCart = cp.captrureItemName();
					Assert.assertTrue(productInCart.equals(PRODUCTNAME));
					System.out.println(productInCart);
					
	}

				
					


}
