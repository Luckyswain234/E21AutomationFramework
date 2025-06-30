package pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProjectTo_Cart {
	public static void main(String[] args) {
//		Lunch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Load the URL
		driver.get("https://www.saucedemo.com/");
		
		//Login to Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		
		//Click on a product and add to cart
		driver.findElement(By.xpath("//div[.='Sauce Labs Bike Light']")).click();
		driver.findElement(By.name("add-to-cart")).click();
		
		//Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		//Validate for the product in cart
		String productInCart= driver.findElement(By.className("inventory_item_name")).getText();
		if(productInCart.equals("Sauce Labs Bike Light")) {
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
