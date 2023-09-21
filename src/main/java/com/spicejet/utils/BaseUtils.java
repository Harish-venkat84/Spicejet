package com.spicejet.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spicejet.po_manager.PageObjectManager;
import com.spicejet.property.FileReaderManager;

public class BaseUtils {

	public static WebDriver driver;

	// Page Object Manager class object reference 
	public static PageObjectManager pageObjectManager;
	
	public static FileReaderManager property = new FileReaderManager();
	
	static ChromeOptions option = new ChromeOptions();
	
	// return the class name as a string
	public String className() {
		
		return this.getClass().getSimpleName() + " class, ";
	}
	
	// this method is user for browser launch
	// parameter ==> (browser -> name), (url -> application url)
	public static WebDriver launchBrowser(String browser, String url, String headLess) {
		
		try {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-geolocation");
			
			if (headLess.equalsIgnoreCase("HeadLess")) {
				
				option.addArguments("--headless=new");
			}
			
			driver = new ChromeDriver(option);
			
		} else if (browser.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
			
		} else if (browser.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		
		pageObjectManager = new PageObjectManager(driver);
		
		}catch(Exception ex) {
			
			System.out.println("problem on launching browser");
			ex.printStackTrace();
		}
		
		return driver;
	}
	
	// this method is used to enter text to the input field like search box, mail id field, password field, etc...
	// parameters => (element, text)
	public void typeText(WebElement element,String text) {

		try { element.sendKeys(text); }catch(Exception ex) {
			
			System.out.println("problem in passing text to the webelement on " + className() + "typeText method");
			ex.printStackTrace();
		}
	}
	
	// click on the particular element like button, radio button, check box, etc...
	// parameter(web element) 
	public void clickElement(WebElement element) {
		
		try { element.click(); }catch (Exception ex) {
			
			System.out.println("problem in clicking button " + className() + "clickElement method");
			
			ex.printStackTrace();
		}
	}
	
	// closes all opened browsers
	public static void closeAllBrowsers() {
		
		try { driver.quit(); }catch(Exception ex) {
			
			System.out.println("problem in closing the all browsers");
			
			ex.printStackTrace();
		}
	}
	
	// close the current browser or tab
	public void closeCurrentBrowser() {
		
		try { driver.close(); }catch(Exception ex) {
			
			System.out.println("problem in closing the current browser tab on " + className() + "closeCurrentBrowser method");
			
			ex.printStackTrace();
		}
	}
	
	// clear text from the input fields
	// parameter => element
	public void clearText(WebElement element) {
		
		try { element.clear(); }catch(Exception ex) {
			
			System.out.println("problem in clearing text on " + className() + "clearText method");
			
			ex.printStackTrace();
		}
	}
	
	// WebDriverWait object return
	// parameter => timeout
	public WebDriverWait waitForMe(long timeout) {

		return new WebDriverWait(driver, Duration.ofSeconds(timeout));

	}

	// This method wait for Element should visible on DOM page
	// parameter => element
	public void visibleOfElement(WebElement element){

		try{ waitForMe(10).until(ExpectedConditions.visibilityOf(element)); }catch (Exception ex){

			System.out.println("problem in web driver wait on "+ className() +"visibleOfElement method");
			ex.printStackTrace();
		}
	}
	
	// this method will wait for element to be present on the DOM page
	// parameter => X_path
	public void presenceOfElement(String path) {
		
		try{ waitForMe(10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path))); }catch(Exception e) {
			
			System.out.println("problem in web driver wait on "+ className() +"presenceOfElement method");
			e.printStackTrace();
		} 
	}
	
	//this method will wait for element should not visible on DOM page
	// parameter => element
	public void elementNotVisible(WebElement element) {
		
		try { waitForMe(10).until(ExpectedConditions.invisibilityOfAllElements(element)); } catch (Exception e) {
			
			System.out.println("problem in web driver wait on "+ className() +"visibleOfElement method");
			e.printStackTrace();
		}
	}
	
	//this method wait for getting page title
	// parameter => title as String
	public void waitForGetTitle(String title) {
		
		try { waitForMe(10).until(ExpectedConditions.titleContains(title)); }catch(Exception ex) {
			
			System.out.println("problem on waiting for get titile on" +className()+ "waitForGetTitle method");
			
			ex.printStackTrace();
		}
	}
	
	// this method will wait for element can able to click 
	// parameter => WebElement
	public void waitForElementClickable(WebElement element) {
		
		try { waitForMe(10).until(ExpectedConditions.elementToBeClickable(element)); }catch(Exception e) {
			
			System.out.println("problem on waiting for element to be clickable "+className()+ "waitForElementClickable method");
			e.printStackTrace();
		}
		
	}
	
	// this method wait for text present on the element
	public void waitTextPresent(WebElement element, String text) {
		
		try {
			
			waitForMe(10).until(ExpectedConditions.textToBePresentInElement(element, text));
		}catch(Exception e) {
			
			System.out.println("problem on waiting for element text on" +className()+ "waitTextPresent method");
		}
	}
	
	public void waitForFrame(WebElement element) {
		
		try {
			
			waitForMe(10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		}catch(Exception e) {
			
			System.out.println("problem on waiting for element text on" +className()+ "waitTextPresent method");
		}
	}
	
	// pageTitle will return the title of the webpage as a String
	public String getPageTitel(){

		try{ return driver.getTitle(); }catch (Exception ex){

			System.out.println("problem on getting the web page title on "+className()+"pageTitle method");
			ex.printStackTrace();
		}

		return null;
	}

	// returns the current URL as a String
	public String currentURL(){

		try{ return driver.getCurrentUrl(); }catch (Exception exception){

			System.out.println("problem on getting the current url on "+ className() + "currentURL method");
			exception.printStackTrace();
		}

		return null;
	}
	
	// return JavascriptExecutor object
	public JavascriptExecutor javaScriptObj() {
		
		JavascriptExecutor js = null;
		
		try {js = (JavascriptExecutor) driver;}catch(Exception ex) {
			
			System.out.println("problem on creating object for Java Script Executor on "+ className() + "javaScriptObj method");
			ex.printStackTrace();
			}
		
		return js;
	}
	
	// this method will scroll web page the specific element, until element visible to the user
	// parameter => element
	public void scrollToElement(WebElement element) {
		
		try {
		
		javaScriptObj().executeScript("arguments[0].scrollIntoView();", element);
		
		}catch (Exception ex) {
			
			System.out.println("problem on Java Script scrollIntoView on "+ className() + "scrollIntoView method");
			ex.printStackTrace();
		}
	}
	
	// this method user for vertical scroll on the web page 
	public void verticalScroll(String down) {
		
		try {
			
			javaScriptObj().executeScript("window.scrollBy(0,"+down+")", "");
			
			}catch (Exception ex) {
				
				System.out.println("problem on Java Script scroll down on "+ className() + "verticalScroll method");
				ex.printStackTrace();
			}
	}
	
	// this method use for click an element on the web page using java script
	public void clickElementUsingJavaScript(WebElement element) {
		
		try {
			
			javaScriptObj().executeScript("arguments[0].click();", element);
			
		} catch (Exception e) {

			System.out.println("problem on clicking using javascript in "+ className()+ "clickElementUsingJavaScript method");
			e.printStackTrace();
		}

	}
	
	// used for clear input field
	public void clerTextUsingJavaScript(WebElement element) {
		try {
			javaScriptObj().executeScript("arguments[0].value = '';", element);
		} catch (Exception e) {
			
			System.out.println("problem clearing input field using javascript");
			e.printStackTrace();
		}
		
	}
	
	// return the Object of the select class
	// parameter => element
	public Select selectObj(WebElement element) {

		Select select = null;
		
		try{ select = new Select(element); }catch(Exception ex) {
			
			System.out.println("problem on creating object for select class on "+ className() + "selectObj method");
			ex.printStackTrace();
		}
		
		return select;
	}
	
	// this is used to select the drop down by visible text
	// parameter => (element, text)
	public void selectVisibleText(WebElement element, String text) {
		
		try{ selectObj(element).selectByVisibleText(text); }catch(Exception ex) {
			
			System.out.println("problem on selecting by visible text on "+ className() + "selectVisibleText method");
			ex.printStackTrace();
		}
	}
	
	// returning object of robot class
	public Robot robotObject() throws AWTException {
		
		Robot robo = new Robot();
		
		return robo;
	}
	
	// this method will press control + V on your keyboard
	public void ctrlV() {
		
		try {
			
			robotObject().keyPress(KeyEvent.VK_CONTROL);
			robotObject().keyPress(KeyEvent.VK_V);
			
			robotObject().keyRelease(KeyEvent.VK_CONTROL);
			robotObject().keyRelease(KeyEvent.VK_V);
		
		}catch(Exception ex) {
			
			System.out.println("problem on pressing control + V on keyboard "+ className()+"ctrlV method");
			
			ex.printStackTrace();
		}
	}
	
	// this method will open a new browser tab
	public void openNewTab() {
		
		try{ driver.switchTo().newWindow(WindowType.TAB); } catch(Exception ex) {
			
			System.out.println("problem on opening new browser tap "+ className() +"openNewTab method");
		}
	}
	
	// this method will return the current window ID 
	public String getCurrentWinID() {
		
		String windID = null;
		
		try{ windID = driver.getWindowHandle(); }catch(Exception ex) {
			
			System.out.println("problem on getting the current window ID " +className()+ "getCurrentWinID method");
			ex.printStackTrace();
		}
		
		return windID;
	}
	
	// this method will return the list of opened window ID 
		public Set<String> getAllWinIDs() {
			
			Set<String> windID = null;
			
			try{ windID = driver.getWindowHandles(); }catch(Exception ex) {
				
				System.out.println("problem on getting the all window ID's " +className()+ "getCurrentWinID method");
				ex.printStackTrace();
			}
			
			return windID;
		}
	
	
	// this method will launch new URL on the current browser tab
	public void launchNewURL(String URL) {
		
		try { driver.navigate().to(URL); }catch(Exception ex) {
			
			System.out.println("problem on launching new url " +className()+ "launchNewURL method");
			ex.printStackTrace();
		}
	}
	
	// this method will switch the driver
	// parameter => wind id
	public void switchDriver(String id) {
		
		try { driver.switchTo().window(id); }catch(Exception ex) {
			
			System.out.println("problem on switching driver " +className()+ "switchDriver method");
		}
	}
	
	// return text as String for web element
	// parameter => web element
	public String getElementText(WebElement element) {
		
		String text = null;
		
		try{ text = element.getText(); }catch(Exception ex) {
			
			System.out.println("problem on getting text from the web element "+ className()+ "getElementText");
		}
		
		return text;
	}
	
	// From this line to below setDate methods for getting time for the calendar picker on the home page 
	LocalDate date = LocalDate.now();
	
	public String getYear() {
		
		return date.toString().substring(0, 4);
	}
	
	public String getMonth() {
		
		return date.toString().substring(5, 7);
	}
	
	public String getDay() {
		
		return date.toString().substring(8);
	}
	
	public String month = null;
	public String year = null;
	public String day = null;
	
	public void setDate() {
		
		int mon = Integer.parseInt(getMonth());
		
		Months[] values = Months.values();
		
		int dat = Integer.parseInt(getDay());
		
		int yea = Integer.parseInt(getYear());
		
		if (dat <= 22) {
				
			month = values[mon-1].name();
			day = String.valueOf(dat + 3);
			year = String.valueOf(yea);
			
			
		}else if(dat >= 22) {
			
			if(values[mon-1].name().equals("December")) {
				
				month = values[0].name();
				day = "1";
				year = String.valueOf(yea + 1);
			
			}else {
			
				month = values[mon].name();
				day = "5";
				year = String.valueOf(yea);
			}
		}
		
	}
	
	
	// this method for fluent wait for polling time for some elements 
	public void fluentWait(WebElement element) {
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300));
		
		wait.until(d -> {
			element.click();
            return true;
        });
		
	}
	
	// this method is used to switch to iFrame
	public void switchToFrame(WebElement element) {
		
		driver.switchTo().frame(element);
	}
	
	// this method used for switching back from frame to default content
	public void switchToDefaultContent() {
		
		driver.switchTo().defaultContent();
	}
	
	// this method will go back to the previous page 
	public void backPage() {
		
		try {driver.navigate().back();}catch(Exception ex) {
			
			System.out.println("Problem on going back page");
			ex.printStackTrace();
		}
	}
	
}
