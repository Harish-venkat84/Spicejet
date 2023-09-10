package com.spicejet.po_models;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class PassengerPage {
	
	public WebDriver driver;
	
	public PassengerPage(WebDriver driver2) {

		this.driver = driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	private WebElement mobileNumber;
	
	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	private WebElement email;
	
	@FindBy(xpath = "//div[text() = 'Passenger Information']")
	private WebElement verifyPassengerPage;
	
	@FindBy(xpath = "//div[text() = 'Passenger 2']//following::div[text() = 'Mr']//parent::div")
	public WebElement selectPerson;
	
	@FindBy(xpath = "//div[text() = 'Passenger 2']//following::div[text() = 'Mrs']//parent::div")
	private WebElement selectMrs;
	
	@FindBy(xpath = "//div[text() = 'Passenger 3']//following::div[text() = 'Select']//parent::div")
	private WebElement selectChildDropDown;

	@FindBy(xpath = "//div[text() = 'Passenger 3']//following::div[text() = 'Master']//parent::div")
	private WebElement selectChildMaster;
	
	public List<WebElement> inputFields(String num){
		
		return driver.findElements(By.xpath("//div[text() = 'Passenger "+num+"']//parent::div//following::input"));
	}
	
	@FindBy(xpath = "//div[text() = 'Next']//parent::div")
	private WebElement nextBtn;
	
	@FindBy(xpath = "//div[text() = 'Continue']//parent::div")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//div[@data-testid='app-loader']")
	private WebElement app_load;
	
}
