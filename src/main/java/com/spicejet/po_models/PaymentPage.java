package com.spicejet.po_models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class PaymentPage {
	
	public WebDriver driver;
	
	public PaymentPage(WebDriver driver2) {
		
		this.driver = driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//iframe[@class='card_number_iframe']")
	private WebElement cardNumberFrame;
	
	@FindBy(xpath = "//iframe[@class='name_on_card_iframe']")
	private WebElement cardNameFrame;
	
	@FindBy(xpath = "//iframe[@class='card_exp_month_iframe']")
	private WebElement cardMonthFrame;
	
	@FindBy(xpath = "//iframe[@class='card_exp_year_iframe']")
	private WebElement cardYearFrame;
	
	@FindBy(xpath = "//iframe[@class='security_code_iframe']")
	private WebElement cardCVVFrame;
	
	@FindBy(xpath = "//div[text() = 'Updating your booking']//parent::div//parent::div")
	private WebElement updatingLoading;

	@FindBy(xpath = "//div[text() = 'Fetching your booking']//parent::div//parent::div")
	private WebElement fetchingLoading;

	@FindBy(xpath = "//div[text() = 'Processing your order']//parent::div//parent::div")
	private WebElement processingLoading;
	
	@FindBy(xpath = "//input[@class='card_number']")
	private WebElement cardNumber;

	@FindBy(id = "name_on_card")
	private WebElement cardName;
	
	@FindBy(id = "card_exp_month")
	private WebElement cardExMonth;
	
	@FindBy(id = "card_exp_year")
	private WebElement cardExYear;
	
	@FindBy(id = "security_code")
	private WebElement cardCVV;
	
	@FindBy(xpath = "//div[text() = 'Proceed to pay']//parent::div")
	private WebElement proceedToPayBtn;
	
	@FindBy(xpath = "//div[text() = 'Payment Failure']")
	private WebElement paymentMessage;
	
	@FindBy(xpath = "//div[text() = 'Something went wrong while processing your payment. Please try again.']")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//div[text() = 'DISMISS']")
	private WebElement errorDismissBtn;
}
