package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import ObjectRepositorty.LOginMethod;
import ObjectRepositorty.inventoryPage;
/**
 * This class consist of basic configuration annotations of TestNG
 * @author Baniprava swain
 */

public class BaseClass {
	public FileUtility fUtil=new FileUtility();
	public javaUtility jUtil = new javaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public WebDriver driver;

	//for Listeners
	public static WebDriver sDriver;

	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("....Database Connection Successful....");
	}
	
//	@Parameters("Browser")
//	@BeforeMethod
	
	@BeforeClass(alwaysRun= true)
	public void bcConfig (/*String pValue*/) throws IOException  
	{
		String URL = fUtil.readDataFromPropertyFile("url");
//		driver = new EdgeDriver();
		driver =new ChromeDriver();
		
//		For Cross Browser execution
//		if(pValue.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(pValue.equals("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new EdgeDriver();
//		}
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicityWight(driver);
		driver.get(URL);
		
		
		//FOR listners
		sDriver =driver;
		
		System.out.println("....Browser Lunch Successful....");
	}
	
	@BeforeMethod(alwaysRun= true)
	public void bmConfig() throws IOException  
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		LOginMethod lp = new LOginMethod(driver);
		lp.LOginMethod(USERNAME,PASSWORD);	
		System.out.println("....Login to Application Successful....");
	}
	@AfterMethod(alwaysRun= true)
	public void amConfig()
	{
		inventoryPage ip =new inventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("...Logout of application successful....");

	}
	
//    @Parameters("Browser")
//	@AfterTest
	
	@AfterClass(alwaysRun= true)
	public void acConfig()
	{
		driver.quit();
		System.out.println(".... Browser closer  Successful....");

	}
	
	@AfterSuite(alwaysRun= true)
	public void asConfig()
	{
		System.out.println("....Database Closer Successful....");
	}
	
}
