package com.spicejet.po_models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver2) {
		
		this.driver = driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//div[text() = 'one way']")
	private WebElement oneWay;
	
	@FindBy(xpath = "//div[text() = 'round trip']")
	private WebElement roundTrip;
	
	@FindBy(xpath = "//div[text() = 'Signup']")
	private WebElement signUpBtn;
	
	@FindBy(xpath = "//div[text() = 'Login']")
	private WebElement homePageLoginBtn;
	
	@FindBy(xpath = "//div[text() = 'Email']")
	private WebElement emailRadioBtn;
	
	@FindBy(xpath = "//input[@type = 'email']")
	private WebElement emailID;
	
	@FindBy(xpath = "//div[text() = 'Please enter a valid email address']")
	private WebElement invalidEmailAddress;
	
	@FindBy(xpath = "//input[@type = 'password']")
	private WebElement password;
	
	@FindBy(xpath = "//div[text()= 'LOGIN']//parent::div")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[text() = 'Hi Harish']")
	private WebElement profileName;
	
	@FindBy(xpath = "//div[text() = 'Invalid Username/Password']")
	private WebElement errorMessage1;

	@FindBy(xpath = "//div[text() = 'Please try again or signup as a new user']")
	private WebElement errorMessage2;
	
	@FindBy(xpath = "//div[text() = 'DISMISS']")
	private WebElement errorMessageDismissBtn;
	
	@FindBy(xpath = "//div[text()= 'From']//parent::div//child::input")
	private WebElement takeOffInputField;
	
	public WebElement selectTakeOffCity(String takeOffCity) {
		
		WebElement takeoff = driver.findElement(By.xpath("//div[text() = '"+takeOffCity+"']"));
		
		return takeoff;
	}
	
	@FindBy(xpath = "//div[text()= 'To']//parent::div//child::input")
	private WebElement landingInputField;
	
	public WebElement selectLandingCity(String landingCity) {
		
		WebElement landing = driver.findElement(By.xpath("//div[text() = '"+landingCity+"']"));
		
		return landing;
	}
	
	public WebElement selectThisMonthCalendarDate(String month, String year, String date) {
		
		WebElement thisMonthDate = driver.findElement(By.xpath("//div[text() = '"+month+" ' and text() = '"+year+"']//parent::div//parent::div//child::div[@data-testid='undefined-calendar-day-"+date+"']"));
		
		return thisMonthDate;
	}
	
	@FindBy(xpath = "//div[text() = '1 Adult']")
	private WebElement passengersDropDowm;
	
	@FindBy(xpath = "//div[@data-testid='Adult-testID-minus-one-cta']")
	private WebElement adultMinus;
	
	@FindBy(xpath = "//div[@data-testid='Adult-testID-plus-one-cta']")
	private WebElement adultPlus;
	
	@FindBy(xpath = "//div[@data-testid='Children-testID-minus-one-cta']")
	private WebElement childMinus;
	
	@FindBy(xpath = "//div[@data-testid='Children-testID-plus-one-cta']")
	private WebElement childPlus;
	
	@FindBy(xpath = "//div[text() = 'Currency']//parent::div")
	private WebElement currencyDropDown;
	
	@FindBy(xpath = "//div[text() = 'USD']")
	private WebElement selectUSD;
	
	@FindBy(xpath = "//div[text() = 'INR']")
	private WebElement selectINR;
	
	@FindBy(xpath = "//div[text() = 'Search Flight']//parent::div")
	private WebElement searchFlightBtn;
	
	@FindBy(xpath = "//img[@src='https://www.spicejet.com/public/loader.gif']")
	private WebElement loader;
	
	// check In
	@FindBy(xpath = "//div[text() = 'check-in']")
	private WebElement checkInBtn;
	
	@FindBy(xpath = "//input[@placeholder='e.g. W3X3H8']")
	private WebElement chickInPRNNumber;
	
	@FindBy(xpath = "//input[@placeholder='john.doe@spicejet.com']")
	private WebElement emailAndLastName;
	
	@FindBy(xpath = "//div[text() = 'Search Booking']//parent::div")
	private WebElement checkInSearchBtn;
	
	@FindBy(xpath = "//div[contains(text(), 'Unable to fetch your booking. Please check the inputs ')]")
	private WebElement checkInErrorMessage;
	
	@FindBy(xpath = "//div[text() = 'DISMISS']")
	private WebElement checkInDismissBtn;
	
	//flight status
	@FindBy(xpath = "//div[text() = 'flight status']//parent::div")
	private WebElement flightStatusBtn;
	
	@FindBy(xpath = "//div[text() = 'Departure Date']//parent::div")
	private WebElement statusDepartureDate;
	
	@FindBy(xpath = "//div[text() = 'Today']")
	private WebElement selectTody;
	
	@FindBy(xpath = "//div[text() = 'Search Flights']//parent::div")
	private WebElement flightStatusSearchFlightBtn;
	
	// manage booking
	@FindBy(xpath = "//div[text() = 'manage booking']//parent::div")
	private WebElement manageBookingBtn;
	
	@FindBy(xpath = "//input[@placeholder='john.doe@spicejet.com / Doe']")
	private WebElement manageBookingLastName;
	
}
