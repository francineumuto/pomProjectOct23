package test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {  

	WebDriver driver;

	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashBoardHeaderText = "DashBoard";
	String userNameAlertMsg = "please enter your user name";
	String passwordAlertMsg = "please enter your password";
	String addCustomerHeaderField = "New Customer";
	String fullName = "selenium";
	String company ="Techfios";
	String email ="abc123@techfios.com";
    String phoneNo ="0123456789";
	


	@Test
	public void UserShouldBeAbleToAddCustomer() {

		// object // by class name

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassWord(password);
		loginPage.clicksigninButton();

		DashBoardPage dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashBoardPage.validateDashboardHeader(dashBoardHeaderText);
		dashBoardPage.clickOnCustomeButton();
		dashBoardPage.clickOnAddCustomeButton();
		
        AddCustomerPage addCustomerPage = PageFactory.initElements(driver,AddCustomerPage.class);
        addCustomerPage.validateAddCustomerPage(addCustomerHeaderField);
        addCustomerPage.insertUserName(fullName);
		
		

//		BrowserFactory.tearDown();

	}

}
