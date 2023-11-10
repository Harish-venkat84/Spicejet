package com.spicejet.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

import com.spicejet.excel_reader.ExcelFileReader;
import com.spicejet.po_manager.PageObjectManager;
import com.spicejet.property.PropertyFileManager;

	// Some classes will extend this BaseUtils class, so I have created some commonly used class objects here. 

public class BaseUtils {

	public static WebDriver driver;
	
	// Log4f2 object creation 
	static Logger logger = LogManager.getLogger(BaseUtils.class.getName());

	// Page Object Manager class object reference 
	public static PageObjectManager pageObjectManager;
	
	// Property file reader class object
	public static PropertyFileManager property = new PropertyFileManager();
	
	// Excel file reader class object
	public static ExcelFileReader excelReader = new ExcelFileReader();
	
	static ChromeOptions option = new ChromeOptions();
	
	// return the class name as a string
	public String exceptionClassNameAndMessage(Exception exceptionObj) {
		
		return " | Default error message --> "+exceptionObj.getMessage() 
		+ " | Method implementation class --> "+exceptionObj.getStackTrace()[0] 
		+ " | Method extends class --> "+exceptionObj.getStackTrace()[1];
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
		
		}catch(Exception exception) {
			
			logger.error("problem on launching browser" 
			+ " | Default error message --> "+exception.getMessage() 
			+ " | Method implementation class --> "+exception.getStackTrace()[0] 
			+ " | Method extends class --> "+exception.getStackTrace()[1]);
		}
		
		return driver;
	}
	
	// this method is used to enter text to the input field like search box, mail id field, password field, etc...
	// parameters => (element, text)
	public void typeText(WebElement element,String text) {

		try { element.sendKeys(text); }catch(Exception exception) {
			
			logger.error("problem in passing text to the webelement" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// click on the particular element like button, radio button, check box, etc...
	// parameter(web element) 
	public void clickElement(WebElement element) {
		
		try { element.click(); }catch (Exception exception) {
			
			logger.error("problem in clicking element -->" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// closes all opened browsers
	public static void closeAllBrowsers() {
		
		try { driver.quit(); }catch(Exception exception) {

			logger.error("problem in closing the all browsers"
			+ " | Default error message --> "+exception.getMessage() 
			+ " | Method implementation class --> "+exception.getStackTrace()[0] 
			+ " | Method extends class --> "+exception.getStackTrace()[1]);
		}
	}
	
	// close the current browser or tab
	public void closeCurrentBrowser() {
		
		try { driver.close(); }catch(Exception exception) {

			logger.error("problem in closing the current browser tab" +exceptionClassNameAndMessage(exception));
		}
	}
	
	// clear text from the input fields
	// parameter => element
	public void clearText(WebElement element) {
		
		try { element.clear(); }catch(Exception exception) {
			
			logger.error("problem in clearing text" + exceptionClassNameAndMessage(exception));
			
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

		try{ waitForMe(10).until(ExpectedConditions.visibilityOf(element)); }catch (Exception exception){

			logger.error("problem in web driver wait for visible of element" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// this method will wait for element to be present on the DOM page
	// parameter => X_path
	public void presenceOfElement(String path) {
		
		try{ waitForMe(10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path))); }catch(Exception exception) {
			
			logger.error("problem in web driver wait for presence of element" + exceptionClassNameAndMessage(exception));
		} 
	}
	
	//this method will wait for element should not visible on DOM page
	// parameter => element
	public void elementNotVisible(WebElement element) {
		
		try { waitForMe(10).until(ExpectedConditions.invisibilityOfAllElements(element)); } catch (Exception exception) {
			
			logger.error("problem in web driver wait" + exceptionClassNameAndMessage(exception));
		}
	}
	
	//this method wait for getting page title
	// parameter => title as String
	public void waitForGetTitle(String title) {
		
		try { waitForMe(10).until(ExpectedConditions.titleContains(title)); }catch(Exception exception) {
			
			logger.error("problem on waiting for get titile" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// this method will wait for element can able to click 
	// parameter => WebElement
	public void waitForElementClickable(WebElement element) {
		
		try { waitForMe(10).until(ExpectedConditions.elementToBeClickable(element)); }catch(Exception exception) {
			
			logger.error("problem on waiting for element to be clickable " + exceptionClassNameAndMessage(exception));
		}
		
	}
	
	// this method wait for text present on the element
	public void waitTextPresent(WebElement element, String text) {
		
		try {
			
			waitForMe(10).until(ExpectedConditions.textToBePresentInElement(element, text));
		}catch(Exception exception) {
			
			logger.error("problem on waiting for element text" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// This method will wait for iframe in the web page
	public void waitForFrame(WebElement element) {
		
		try {
			
			waitForMe(10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		}catch(Exception exception) {
			
			logger.error("problem on waiting for element text" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// pageTitle will return the title of the web page as a String
	public String getPageTitel(){

		try{ return driver.getTitle(); }catch (Exception exception){

			logger.error("problem on getting the web page title" + exceptionClassNameAndMessage(exception));
		}

		return null;
	}

	// returns the current URL as a String
	public String currentURL(){

		try{ return driver.getCurrentUrl(); }catch (Exception exception){

			logger.error("problem on getting the current url" + exceptionClassNameAndMessage(exception));
		}

		return null;
	}
	
	// return JavascriptExecutor object
	public JavascriptExecutor javaScriptObj() {
		
		JavascriptExecutor js = null;
		
		try {js = (JavascriptExecutor) driver;}catch(Exception exception) {
			
			logger.error("problem on creating object for Java Script Executor" + exceptionClassNameAndMessage(exception));
			}
		return js;
	}
	
	// this method will scroll web page the specific element, until element visible to the user
	// parameter => element
	public void scrollToElement(WebElement element) {
		
		try {
		
		javaScriptObj().executeScript("arguments[0].scrollIntoView();", element);
		
		}catch (Exception exception) {
			
			logger.error("problem on Java Script scrollIntoView" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// this method user for vertical scroll on the web page 
	public void verticalScroll(String down) {
		
		try {
			
			javaScriptObj().executeScript("window.scrollBy(0,"+down+")", "");
			
			}catch (Exception exception) {
				
				logger.error("problem on Java Script scroll down" + exceptionClassNameAndMessage(exception));
			}
	}
	
	// this method use for click an element on the web page using java script
	public void clickElementUsingJavaScript(WebElement element) {
		
		try {
			
			javaScriptObj().executeScript("arguments[0].click();", element);
			
		} catch (Exception exception) {

			logger.error("problem on clicking using javascript" + exceptionClassNameAndMessage(exception));
		}

	}
	
	// used for clear input field
	public void clerTextUsingJavaScript(WebElement element) {
		try {
			javaScriptObj().executeScript("arguments[0].value = '';", element);
		} catch (Exception exception) {
			
			logger.error("problem clearing input field using javascript" + exceptionClassNameAndMessage(exception));
		}
		
	}
	
	// return the Object of the select class
	// parameter => element
	public Select selectObj(WebElement element) {

		Select select = null;
		
		try{ select = new Select(element); }catch(Exception exception) {
			
			logger.error("problem on creating object for select class" + exceptionClassNameAndMessage(exception));
		}
		
		return select;
	}
	
	// this is used to select the drop down by visible text
	// parameter => (element, text)
	public void selectVisibleText(WebElement element, String text) {
		
		try{ selectObj(element).selectByVisibleText(text); }catch(Exception exception) {
			
			logger.error("problem on selecting by visible text" + exceptionClassNameAndMessage(exception));
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
		
		}catch(Exception exception) {
			
			logger.error("problem on pressing control + V on keyboard" + exceptionClassNameAndMessage(exception));
			
		}
	}
	
	// this method will open a new browser tab
	public void openNewTab() {
		
		try{ driver.switchTo().newWindow(WindowType.TAB); } catch(Exception exception) {
			
			logger.error("problem on opening new browser tap "+ exceptionClassNameAndMessage(exception));
		}
	}
	
	// this method will return the current window ID 
	public String getCurrentWinID() {
		
		String windID = null;
		
		try{ windID = driver.getWindowHandle(); }catch(Exception exception) {
			
			logger.error("problem on getting the current window ID" + exceptionClassNameAndMessage(exception));
		}
		
		return windID;
	}
	
	// this method will return the list of opened window ID 
		public Set<String> getAllWinIDs() {
			
			Set<String> windID = null;
			
			try{ windID = driver.getWindowHandles(); }catch(Exception exception) {
				
				logger.error("problem on getting the all window ID's" + exceptionClassNameAndMessage(exception));
			}
			
			return windID;
		}
	
	
	// this method will launch new URL on the current browser tab
	public void launchNewURL(String URL) {
		
		try { driver.navigate().to(URL); }catch(Exception exception) {
			
			logger.error("problem on launching new url" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// this method will switch the driver
	// parameter => wind id
	public void switchDriver(String id) {
		
		try { driver.switchTo().window(id); }catch(Exception exception) {
			
			logger.error("problem on switching driver" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// return text as String for web element
	// parameter => web element
	public String getElementText(WebElement element) {
		
		String text = null;
		
		try{ text = element.getText(); }catch(Exception exception) {
			
			logger.error("problem on getting text from the web element" + exceptionClassNameAndMessage(exception));
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
		
		try { driver.switchTo().frame(element); } catch (Exception exception) {
			
			logger.error("problem on switching to frame" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// this method used for switching back from frame to default content
	public void switchToDefaultContent() {
		
		try { driver.switchTo().defaultContent(); } catch (Exception exception) {
			
			logger.error("problem on switching frame to default content" + exceptionClassNameAndMessage(exception));
		}
	}
	
	// this method will go back to the previous page 
	public void backPage() {
		
		try {driver.navigate().back();}catch(Exception exception) {
			
			logger.error("Problem on going back page" + exceptionClassNameAndMessage(exception));
		}
	}
	
	protected static int imageCount = 0;
	
	public void takeSnapShot(WebDriver webdriver,String fileWithPath) {
		
		try {
			
			TakesScreenshot scrShot =((TakesScreenshot)webdriver);
			
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			File DestFile=new File(fileWithPath);
			
			FileUtils.copyFile(SrcFile, DestFile);
			
		} catch (Exception exception) {

			logger.error("Problem on Taking snap shot" + exceptionClassNameAndMessage(exception));
		
		}
	}
}
