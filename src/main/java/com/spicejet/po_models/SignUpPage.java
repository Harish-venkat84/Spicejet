package com.spicejet.po_models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class SignUpPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//option[text() = 'Select an option']//parent::select")
	private WebElement selectTitle;
	
	@FindBy(id = "first_name")
	private WebElement firstName;
	
	@FindBy(id = "last_name")
	private WebElement lastName;
	
	@FindBy(xpath = "//option[text() = 'select country']//parent::select")
	private WebElement selectCountry;
	
	@FindBy(id = "dobDate")
	private WebElement dateOfBrith;
	
	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	private WebElement selectMonth;
	
	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	private WebElement selectYear;
	
	@FindBy(xpath = "//div[@tabindex='-1' and text() = '16']")
	private WebElement selectDate;
	
	@FindBy(xpath = "//input[@type = 'tel']")
	private WebElement mobileNumber;
	
	@FindBy(xpath = "//div[@id = 'loader-modal']")
	private WebElement loading;
	
	@FindBy(xpath = "//div[@class='p-5']")
	private WebElement image;
	
	@FindBy(id = "email_id")
	private WebElement mailID;
	
	@FindBy(id = "new-password")
	private WebElement password;
	
	@FindBy(id = "c-password")
	private WebElement conPassword;
	
	@FindBy(xpath = "//input[@type = 'checkbox']")
	private WebElement agreeCheckBox;
	
	@FindBy(xpath = "//button[text() = 'Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[text() = 'Member account exists with given mobile number']")
	private WebElement existingMobileNumberErrorMessage;
	
	@FindBy(xpath = "//div[text() = 'Member account exists with given email ID']")
	private WebElement existingEmailIDErrorMessage;
	
	public SignUpPage(WebDriver driver2) {
	
		this.driver = driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	
}
