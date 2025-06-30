package pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtility.FileUtility;
import genericUtility.SeleniumUtility;

public class AddLowestPriceProductTocart {

	private static final String PRODUCTNAME = null;

	public static void main(String[] args) throws IOException {
		//create object of utilities
		FileUtility futil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		//Reading data from property file
				
				String URL=futil.readDataFromPropertyFile("url");
				String USERNAME=futil.readDataFromPropertyFile("username");
				String PASSWORD=futil.readDataFromPropertyFile("password");
				
				
//				// Read the Test Data from Excel file
								
				String SORTOPTION= futil.readDataFromExcelFile("products", 4, 2);
			
			    String PRODUCTNAME= futil.readDataFromExcelFile("products", 4, 3);
				
				
//				Lunch the browser
				WebDriver driver=new EdgeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addImplicityWight(driver);
				
//				Load the URL
				driver.get(URL);
				
				//Login to Application
				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.name("login-button")).click();
				
				//chose the short option from dropdown
				WebElement dropdownFilter = driver.findElement(By.className("product_sort_container")); 
				Select s = new Select(dropdownFilter);
				s.selectByVisibleText(PRODUCTNAME);
				
				// click on the product and add to caret
				driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
				driver.findElement(By.name("add-to-cart")).click();
				
				//Navigate to cart
				driver.findElement(By.id("shopping_cart_container")).click();
				
				//Validate for the product in cart
				String productInCart= driver.findElement(By.className("inventory_item_name")).getText();
				
				if(productInCart.equals(PRODUCTNAME)) {
					System.out.println(productInCart);
					System.out.println("PASS");
				}
				else {
					System.out.println("FAIL");
				}
				//logout application
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.linkText("Logout")).click();
				

			}
				
		

	}



