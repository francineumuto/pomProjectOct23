package page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage {

	WebDriver driver;
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		
	}

	@FindBy(how = How.XPATH, using ="/html/body/div[1]/section/div/div[2]/div/div/header/div")
	WebElement dashBoardHeadrElement;
	@FindBy(how = How.XPATH, using ="/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span")WebElement customerButtonElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"customers\"]/li[2]/a/span")WebElement addcustomerButtonElement;
	
	
	public void validateDashboardHeader(String dashBoardHeaderText) {
		Assert.assertEquals( dashBoardHeadrElement.getText(),  dashBoardHeaderText, "dashboard page not found");
	}
	
	public void clickOnCustomeButton() {
		customerButtonElement.click();
		
	}
	public void clickOnAddCustomeButton() {
		addcustomerButtonElement.click();
		
	}
}