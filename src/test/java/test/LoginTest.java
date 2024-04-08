package test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;

	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashBoardHeaderText = "DashBoard";
	String userNameAlertMsg = "please enter your user name";
	String passwordAlertMsg = "please enter your password";

	@Test
	public void validUserShouldBeAbleToLogin() {

		// object // by class name

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassWord(password);
		loginPage.clicksigninButton();

		DashBoardPage dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashBoardPage.validateDashboardHeader(dashBoardHeaderText);

		BrowserFactory.tearDown();

	}

	public void validateAlertMessage() {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clicksigninButton();
		loginPage.validateUserNameAlertMsg(userNameAlertMsg);
		
		loginPage.insertUserName(userName);
		loginPage.clicksigninButton();
		loginPage.validatePasswordAlertMsg(passwordAlertMsg);
		
		BrowserFactory.tearDown();

	}

}
