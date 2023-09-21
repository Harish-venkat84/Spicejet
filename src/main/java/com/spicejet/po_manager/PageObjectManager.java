package com.spicejet.po_manager;

import org.openqa.selenium.WebDriver;

import com.spicejet.po_models.AddOnPage;
import com.spicejet.po_models.FlightListedPage;
import com.spicejet.po_models.HomePage;
import com.spicejet.po_models.PassengerPage;
import com.spicejet.po_models.PaymentPage;
import com.spicejet.po_models.SignUpPage;

public class PageObjectManager {
	
	/*
	 * This class used to create the Object reference for the Page Object Model classes 	
	 */
	
	public WebDriver driver;
	
	private HomePage homepage;
	
	private SignUpPage signUp;
	
	private FlightListedPage listFlight;
	
	private PassengerPage passenger;
	
	private AddOnPage addOn;
	
	private PaymentPage payment;
	
	public PageObjectManager(WebDriver driver2) {
		
		if (driver == null) {
			
			this.driver = driver2;
		}
	}
	
	public HomePage getHomePage() {
		
		if (homepage == null) {
			
			homepage = new HomePage(driver);
		}
		
		return homepage;
	}
	
	public SignUpPage getSignUp() {
		
		if (signUp == null) {
			
			signUp = new SignUpPage(driver);
		}
		
		return signUp;
	}
	
	public FlightListedPage getFlightPage() {
		
		if (listFlight == null) {
			
			listFlight = new FlightListedPage(driver);
		}
		
		return listFlight;
	}
	
	public PassengerPage getPassengerPage() {
		
		if (passenger == null) {
			
			passenger = new PassengerPage(driver);
		}
		
		return passenger;
	}
	
	public AddOnPage getAddOnPage() {
		
		if (addOn == null) {
			
			addOn = new AddOnPage(driver);
		}
		
		return addOn;
	}
	
	public PaymentPage getPaymentPage() {
		
		if (payment == null) {
			
			payment = new PaymentPage(driver);
		}
		
		return payment;
	}

}
