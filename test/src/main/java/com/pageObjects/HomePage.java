package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id='btn-cookie-allow']")
	WebElement allowCookies;
	
	public WebElement AllowCookies() {
		return allowCookies;

	}

	@FindBy(xpath = "//*[text()='Account']")
	WebElement accountIcon;

	public WebElement AccountIocn() {
		return accountIcon;

	}

	@FindBy(xpath = "//*[@class='action action-register primary']")
	WebElement createAnAccount;

	public WebElement CreateAnAcccount() {
		return createAnAccount;
	}

}
