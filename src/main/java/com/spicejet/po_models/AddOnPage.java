package com.spicejet.po_models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class AddOnPage {

	public WebDriver driver;
	
	public AddOnPage(WebDriver driver2) {
		
		this.driver = driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//button[text() = 'Book Now']")
	private WebElement lowPriceClose;
	
	@FindBy(xpath = "//div[text() = 'Continue']//parent::div[@data-testid='add-ons-continue-footer-button'  and not(@id = 'button')]")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//span[text() = 'Skip this to skip comfort.']")
	private WebElement clickSkip;
	
	@FindBy(xpath = "//div[@data-testid='app-loader']")
	private WebElement app_load;
}
