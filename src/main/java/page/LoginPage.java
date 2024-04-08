package page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
	}
	// attribute or valiable
//	WebElement userNameElement1 = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));

	@FindBy(how = How.XPATH, using = "//*[@id=\"user_name\"]")
	WebElement userNameElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement passwordElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"login_submit\"]")
	WebElement signinButtonElement;

	// methods
	// individual
	public void insertUserName(String userName) {

		userNameElement.sendKeys(userName);

	}

	public void insertPassWord(String passWord) {

		passwordElement.sendKeys(passWord);

		
	}

	public void clicksigninButton() {

		signinButtonElement.click();
	}
	
	
	//combined
	
	public void performLogin( String userName, String Password) {
		
		userNameElement.sendKeys("userName");
		passwordElement.sendKeys("passWord");
		signinButtonElement.click();
	}
	
	public void validateUserNameAlertMsg(String expectedAlertMsg ) {
		 String actualAlertMsg = driver.switchTo().alert().getText();
		 Assert.assertEquals(actualAlertMsg, expectedAlertMsg, "UserName Error mgs do not match.");
		 driver.switchTo().alert().accept();
	}
	public void validatePasswordAlertMsg(String expectedAlertMsg ) {
		 String actualAlertMsg = driver.switchTo().alert().getText();
		 Assert.assertEquals(actualAlertMsg, expectedAlertMsg, "password alert mgs do not match.");
		 driver.switchTo().alert().accept();
	}
}