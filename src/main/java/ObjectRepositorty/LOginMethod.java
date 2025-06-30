package ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LOginMethod {
	//rule 1
	// rule 2
	//Declaration
	@FindBy(id = "user-name")//
	private WebElement usernameRdt;
//	
//	  @FindAll identifay single webelement with multiple locator
//	 OR operator
//	 Auto heal;ing process
	 
//	@FindAll({@FindBy(id = "user-name"),@FindBy(name = "user-name")})
//	private WebElement usernameEdt;
	
//	  Findbys identifies single webeleement with multiple locator
//	 AND operator
//	 
//	@FindBys({@FindBy(id = "user-name"),@FindBy(name = "user-name")})
//	private WebElement usernameEdt;
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(id ="login-button")
	private WebElement loginBtn;
	
			
	
	//rule-3
	//initialization
	public LOginMethod(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}

	//rule 4
		//Utilization

	public WebElement getUsernameRdt() {
		return usernameRdt;
	}



	public WebElement getPasswordEdt() {
		return passwordEdt;
	}



	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
 //Business - generic method - project specific
	public void LOginMethod(String un , String pwd)
	{
		usernameRdt.sendKeys(un);
		passwordEdt.sendKeys(pwd);
		loginBtn.click();
		
	}

}
