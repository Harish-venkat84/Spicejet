package com.spicejet.po_models;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class FlightListedPage {

	public WebDriver driver;
	
	public FlightListedPage(WebDriver driver2) {
		
		this.driver = driver2;
	
		PageFactory.initElements(driver2, this);
	}

	//div[text() = 'SpiceSaver']//parent::div
	
	@FindBy(xpath = "//div[@data-testid='searchPage-sortingOption-spicesaver-child']")
	private WebElement sortPrice;
	
	public List<WebElement> getlowestPrice(){
		
		return driver.findElements(By.xpath("//div[@data-testid= 'spicesaver-flight-select-radio-button-0']//parent::div[@tabindex='0']"));
	}
	
	@FindBy(xpath = "//div[@data-testid= 'spicesaver-flight-select-radio-button-0']//parent::div[@tabindex='0']")
	private WebElement singleLowestPrice;

	@FindBy(xpath = "//div[text() = 'Continue']//parent::div[@data-testid='continue-search-page-cta']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//span[text() = 'One Way :']//parent::span")
	private WebElement validateOnewWay;
	
	@FindBy(xpath = "//span[text() = 'Passengers : ']//parent::span")
	private WebElement validatePassenger;
	
}
