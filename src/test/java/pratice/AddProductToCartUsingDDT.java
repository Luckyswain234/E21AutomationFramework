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
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepositorty.LOginMethod;
import genericUtility.FileUtility;
import genericUtility.SeleniumUtility;

public class AddProductToCartUsingDDT {

	private static final String PROCUCTNAME = null;

	public static void main(String[] args) throws IOException {
		// creat object of Utilitiefd
		FileUtility futil = new FileUtility();
		SeleniumUtility sUtil= new SeleniumUtility();

		//Reading data from property file
		String URL=futil.readDataFromPropertyFile("url");
		String USERNAME=futil.readDataFromPropertyFile("username");
		String PASSWORD=futil.readDataFromPropertyFile("password");
		
		
		
//		// Read the Test Data from Excel file
		String PRODUCTNAME = futil.readDataFromExcelFile("products", 1, 2);
		
//		Lunch the browser
		WebDriver driver=new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicityWight(driver);
//		Load the URL
		driver.get(URL);
		
		//Login to Application
		
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.name("login-button")).click();
		LOginMethod lp = new LOginMethod(driver);
		lp.getUsernameRdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
//		
//		lp.LOginMethod(USERNAME,PASSWORD);
		
		//Click on a product and add to cart
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		driver.findElement(By.name("add-to-cart")).click();
		
		//Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		//Validate for the product in cart
		String productInCart= driver.findElement(By.className("inventory_item_name")).getText();
		
		if(productInCart.equals(PRODUCTNAME)) {
			System.out.println(productInCart);
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		//logout application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		

	}

}
