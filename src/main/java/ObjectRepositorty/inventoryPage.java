package ObjectRepositorty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class inventoryPage extends SeleniumUtility {
//	@FindBy(className ="product_sort_container")
//	private WebElement  productnameRDT;
	
	
	@FindBy( id="react-burger-menu-btn") 
	private WebElement menuBtn;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLnk;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartContainerBtn;

	private WebElement sortDropDown;
	
	//initialization
	public inventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	


	public WebElement getSortDropDown() {
		return sortDropDown;
	}
	
	public WebElement getMenuBtn() {
		return menuBtn;
	}

	
	public WebElement getLogoutLnk() {
		return logoutLnk;
	}

	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}
	 //businees Libray
	/**
	 * This method will perform logout operation
	 */
	public void logoutOfApp() {
		menuBtn.click();
		logoutLnk.click();
	}
	/**
	 * This method will click on a cart  containerBtn()

	 */
	public void clickONCartContainerBtn()
	{
		cartContainerBtn.click();
	}
	/**
	 * This method will click on product
	 * @param driver
	 * @param ProductName
	 */
	
	public void clickOnAProduct(WebDriver driver ,String ProductName)
	{
		driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
	}
	
	public void clickOnLowestPriceProduct(WebDriver driver,String sortoption, String ProductName)
	{
		handelDropdown( sortDropDown,sortoption );
		driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
		
	}


	
	}
	
	
	
