package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of generic method related to selenium
 * @Baniprava swain
 */

public class SeleniumUtility {
	

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizewindow(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	/**
	 * This method will Fullscreen the window
	 * @param driver
	 */
	public void fullscreenwindow(WebDriver driver) {
		driver.manage().window().fullscreen();
		
	}
	/**
	 * This method will and implicity wait for 10 seconds
	 * @param driver
	 */
	public void addImplicityWight( WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
//	public void addExplicityWight( WebDriver driver) {
//		driver
//	}
	
	/**
	 * This method will wait for 10 seconds for element to be Clickable
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait for 1p0 seconds for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
	
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	}
	/**
	 * This method will handele drop-down by Index
	 * @param element
	 * @param index
	 */
	public void handelDropdown(WebElement element ,int index)
	{
		Select s =new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will handele dropdown by visible Text
	 * @param element
	 * @param visibleText
	 */
	public void handelDropdown(WebElement element ,String visibleText)
	{
	Select s =new Select(element);
	s.selectByVisibleText(visibleText);
	}
	/**
	 * This method will handele drop down by value
	 * @param value
	 * @param element
	 */
	public void handelDropdown( String value ,WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will perform mouse hovering action on web element
	 * @param driver
	 * @param element
	 */
	
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();	}

	// Drag and drop, DoublClick, context click, click and hold, release
	
	/**
	 * This method will drag and drop action on web element
	 * @param driver
	 * @param srcEle
	 * @param tarele
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement tarele) 
	{
		Actions act =new Actions(driver);
		act.dragAndDrop(srcEle, tarele).perform();
	}
	
	/**
	 * This method will perform double click action on web element
	 * @param driver
	 * @param element
	 */
	public void dobleClickAction(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.doubleClick(element).perform();

	}
	
	/**
	 * This method will perform right click action on web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) 
	{
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform click and hold action on web element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	 
	/**
	 * This method will perform release action on web element
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.release(element).perform();
	}
	
	/**
	 * This method will  perform Scroll action on web element
	 * @param driver
	 * @param element
	 */
	public void scrollAction( WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();

	}
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will switch to frame based on Name or ID
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver, String frameNameorId)
	{
		driver.switchTo().frame(frameNameorId);
	}
	/**
	 * This method will switch the control to imiodiate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch the control to main page
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch to window
	 * @param driver
	 * @param windowID
	 */
	public void switchToWindow(WebDriver driver, String windowID)
	{
		driver.switchTo().window(windowID);
	}
	/**
	 * This method will  accept alert pop-up
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss alert pop-up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture text from alert pop-up and return to call
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public void EnterAlertDate(WebDriver driver,String date)
	{
		driver.switchTo().alert().sendKeys(date);
	}
	/**
	 * This method will scrollDown by 500 units
	 * @param driver
	 */
	
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	public void captureScreenShot(WebDriver driver , String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dsc = new File(".\\screenShots\\take1.png");
		org.openqa.selenium.io.FileHandler.copy(src, dsc);
		
	}
	
	
	
	
	
	
	
	




}
