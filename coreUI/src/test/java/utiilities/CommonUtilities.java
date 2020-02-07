package utiilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;

import pageObjects.BaseClass;

public class CommonUtilities extends BaseClass {
	
	
	
//public WebDriver driver ;
private String browser;
private int implicitWait;
private int pageLoadTimeout;
private String screenshotOnFail;
	

public CommonUtilities(WebDriver driver) {
	this.driver = driver;
	
}
	
	
	public String takescreenshot(String path,WebDriver driver) throws IOException {
	File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File(path));
	return path;
}
	
	public void addCucumberStep(String description , String stepName , boolean addScreenshot , Status status) throws IOException {
		
		switch(status) {
		case FAIL:
			if(addScreenshot) {
				String path = takescreenshot(System.getProperty("user.dir")+"//Screenshots//"+stepName+".png", driver);
				//logger.fail(description,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}else {
				//logger.log(com.aventstack.extentreports.extentreports.Status.FAIL, description);
				System.out.println("in else block");
		}
		break;
		case PASS:
			if(addScreenshot) {
				String path = takescreenshot(stepName, driver);
				Reporter.addStepLog(description);
				Reporter.addScreenCaptureFromPath(path);
			//	logger.pass(description,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}else {
				Reporter.addStepLog(description);
				System.out.println("in else block");
				//logger.log(com.aventstack.extentreports.extentreports.Status.PASS, description);
				
		}
		break;
			
	}
		
}
	/* This method returns a random string
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	/* This method used for click on an element
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public  void Click(WebElement ele)
	{
		System.out.println("++++++++++++++++ele clicked+++++++++++++++++++++++++");
	    ele.click();
	}
	
	
	/* This method used for Opening an URL on different browser and maximize it
	 * 
	* @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void OpenURL(String url ) throws IOException {//, String stepName , String message
		try {
			Properties cnfgProp = new Properties();
			FileInputStream ConfigProf = new FileInputStream(".//config.properties");
			cnfgProp.load(ConfigProf);
			String brwsr = cnfgProp.getProperty("browser");
			System.out.println(cnfgProp.getProperty("chromepath"));
			
			if(brwsr.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", cnfgProp.getProperty("chromepath"));
			    driver = new ChromeDriver();
			    System.out.println("browser is chrome");
			    driver.get(url);
			    driver.manage().window().maximize();
			}else if(brwsr.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", cnfgProp.getProperty("firefoxpath"));
			    driver = new FirefoxDriver();
			    driver.get(url);
			    driver.manage().window().maximize();
			}else if(brwsr.equals("ie")) {
				System.setProperty("webdriver.ie.driver", cnfgProp.getProperty("iepath"));
				 driver = new InternetExplorerDriver();
				 driver.get(url);
				 driver.manage().window().maximize();
			}else {
				System.setProperty("webdriver.chrome.driver", cnfgProp.getProperty("chromepath"));
			    driver = new ChromeDriver();
			    driver.get(url);
			    driver.manage().window().maximize();
			}
			super.initializeObjects();
			
			addCucumberStep("Successful","stepName",true,Status.PASS);
		}catch (Exception e) {
			addCucumberStep("Successful","stepName",true,Status.FAIL);
			e.getMessage();
		}
	}
	
	
	/* This method used for switching  to a window
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */	
	public void switchWindow(int window , String stepName)  throws IOException {
		try {
			Object[] windows = driver.getWindowHandles().toArray();
			driver.switchTo().window(windows[window].toString());
			addCucumberStep("SwitchWindow Successful",stepName,true,Status.PASS);
		}catch(Exception e) {
			addCucumberStep("SwitchWindow UnSuccessful",stepName,true,Status.FAIL);
			e.getMessage();
		}
		
	}
	
	/* This method used for closing the used browser
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void closebrowser() {
		Object[] windows = driver.getWindowHandles().toArray();
		for(int i = 0 ; i<windows.length;i++) {
			driver.switchTo().window(windows[i].toString());
			driver.close();
		}
	}
	
	public void DriverFunctions(WebDriver driver, String browser, int implicitWait, int pageLoadTimeout) {
		this.driver=driver;
		this.browser=browser;
		this.implicitWait=implicitWait;
		this.pageLoadTimeout=pageLoadTimeout;
		
	}
	
	
	/* This method used for closing all window opened by WebDriver
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public static void closeAllBrowserWindows(WebDriver driver) {
		Set<String> handles = driver.getWindowHandles();
		if(handles.size()>1) {
			logger.info("Closing"+ handles.size() + "window(s).");
			for(String windowID : handles) {
				logger.info("--closing window handle: "+windowID);
				driver.switchTo().window(windowID).close();
			}
		}else if(handles.size() == 1) {
			logger.info("-- closing last opened window. --");
			
		}else {
			logger.info(" -- There were no window handles to close. --");
		}
		driver.quit();
		
	}
	
	
	/* This method used for unhighlighting the element using javaScriptExecutor
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void unhighlight(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element,"");
		
	}
	
	/* This method used for highlighting the element using javaScriptExecutor
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void highlightElement(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
				element,"color: ; border: 5px solid yellow;");
		
	}
	

	
	public WebElement executeStep(WebElement element , String description) throws IOException {
		logger.info("-- Inside --" + description);
		String[] stepDetails = new String[3];
		int xCoordinate = 0;
		int yCoordinate = 0;
		String serielNo = randomString();
		String reportPathBrowser = null;
		String screenshotpath = reportPathBrowser + "\\screenshots\\" +serielNo+ ".png";
		String status;
		try {
			xCoordinate = element.getLocation().x;
			yCoordinate = element.getLocation().y;
			highlightElement(element);
			status = "pass";
			if(screenshotOnFail.equals("Y")) {
				System.out.println("Only screenshot will be captured in failed cases");
				
			}else {
				takescreenshot(screenshotpath,driver);
			}
			Thread.sleep(500);
			unhighlight(element);
		}catch(Exception e) {
			//updateStep("Element not Found", "Fail - Exception :" + "\n\t\t" + e.getClass().getSimpleName());
			logger.info("-- Element not Found --");
		} finally {
			stepDetails[0]= description ;
			//stepDetails[1]= status;
			stepDetails[2]= xCoordinate + "," + yCoordinate ;
			//serielNo++;
		}
	//	stepDetails.add(stepDetails);
		return element;
	
		
	}
	
	public void updateStep(String description ,String stepName, String status) {
		logger.info("************" + description );
		
		String[] stepDetails = new String[4]; 
		stepDetails[0] = description ;
		stepDetails[1] = status ;
		stepDetails[2] = 0 + ","+ 0 ;
		System.out.println("Update step***************************************"+stepDetails[0]);
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		String ScreenPath = System.getProperty("user.dir") + "\\Screenshots\\" + stepName + ".png";
		if(screenshotOnFail.equalsIgnoreCase("Y")) {
			if(status.contains("Fail")) {
				try {
					takescreenshot(ScreenPath,driver);
					
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			try {
				takescreenshot(ScreenPath,driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*
		 * stepDetails.add(stepDetails); serielNo++ ; if(status.equalsIgnoreCase("Fail")
		 * && SuiteRunner.suiteRun == true) { AssertJunit.assertTrue(false); }
		 */
	}
	
	/* This method used for Accepting the Alert button
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void alertAccept() {
		logger.info("---Alert Accepted---");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			logger.info("---Inside Alert Accept---");
			updateStep("Alert Accept", "Steps","Pass");
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	/* This method used for Rejecting the Alert button
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void alertReject() {
		logger.info("---Alert Rejected---");
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			logger.info("---Inside Alert Dismiss---");
			updateStep("Alert Dismiss", "Steps","Pass");
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	/* This method used for fetching text from alert box
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	@SuppressWarnings("finally")
	public String getAlertData() {
		try {
			logger.info("----GET ALERT DATA----");
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			return text;
		}catch(UnhandledAlertException e) {
			UnhandledAlertException uae = new UnhandledAlertException(browser);
			return uae.getAlertText();
		}
	}
	
	
	/* This method used for sending text to alert box
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void setAlert(String input) {
		logger.info("--- SET ALERT DATA---");
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(input);
			alert.accept();
			updateStep("Set Alert","Steps","Pass");
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	/* This method is used for checking wheather Alert is present or not 
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public Boolean isAlertPresent() {
		logger.info("--- IS ALERT PRESENT---");
		try {
			Alert alert = driver.switchTo().alert();
			updateStep("Alert Present","Steps","Pass");
			return true;
		}catch (NoAlertPresentException e) {
			updateStep("Alert Not Present","Steps","Pass");
			return false;
		}catch(UnhandledAlertException e2) {
			updateStep("Alert Present","Steps","Pass");
			return true;
		}
	}
	
	/* This method is used for checking wheather element is present or not 
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public Boolean isElementPresent(WebElement ele , String description) {
		logger.info("---IS ELEMENT PRESENT---");
		try {
			highlightElement(ele);
			updateStep("Element Found:"+ description ,"Steps", "Pass");
			unhighlight(ele);
			return true;
		}catch(Exception e) {
			e.getMessage();
			updateStep("Element Not Found:"+ description ,"Steps", "Fail");
			return false;
		}
	}
	
	/* This method is used for checking expected data with actual data if it fails then execution ends
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public <T> T assertEquals(T Expected , T Actual) {
		try {
			logger.info("---CHECKS IF EQUAL---");
			logger.info("Exp :"+ Expected);
			logger.info("Act :"+ Actual);
			if(Expected.equals(Actual)) {
				updateStep("Validtion passed - Expected: "+Expected + "Actual :"+Actual ,"Steps","Pass");
			}else {
				updateStep("Validtion Failed - Expected: "+Expected + "Actual :"+Actual ,"Steps","Fail");
			}
		} catch(Exception e) {
			e.getMessage();
			updateStep("Validtion Failed - Expected: "+Expected + "Actual :"+Actual ,"Steps","Fail - Exception : "+"\n\t\t" + e.getClass().getSimpleName());
		}
		return Actual;
	}
	
	
	/* This method returns true or false if assertion passed or failed subsequently  
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void assertTrue(Boolean result) {
		logger.info("---CHECKS IF TRUE---");
		if(result.equals(true)) {
			updateStep("Validation Passed" ,"Steps", "Pass");
		}else {
			updateStep("Validation failed" ,"Steps","Fail");
		}
	}
	
	
	/* This method returns the length of the string  
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public String getStringValue(String baseword , String startword , String endword) {
		logger.info("---GET STRING VALUE---");
		int a = startword.length();
		int b = baseword.indexOf(startword);
		int startPoint = a + b;
		int length = baseword.substring(a+b).indexOf(endword);
		int endPoint = startPoint + length ;
		return(baseword.substring(startPoint, endPoint));
	}
	
	
	/* This method used to swith to the desired frame using its ID  
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
//	public void switchFrame(String frameId) {
//		try {
//			System.out.println("------------------------------------------------------------");
//			driver.switchTo().frame(frameId);
//			updateStep("Switch to Frame "+ frameId ,"Steps", "Pass");
//		}catch(Exception e) {
//			e.getMessage();
//			updateStep("Switch to Frame" + frameId ,"Steps" , "Fail - Exception: "+"\n\t\t" + e.getClass().getSimpleName());
//		}
//	}
	public void switchFrameID(String frameId) {
		try {
			System.out.println("+++++++++++++++++++Inside frame++++++++++++++++++");
			driver.switchTo().frame(frameId);
			//updateStep("Switch to Frame "+ frameId ,"Steps", "Pass");
		}catch(Exception e) {
			e.getMessage();
			//updateStep("Switch to Frame" + frameId ,"Steps" , "Fail - Exception: "+"\n\t\t" + e.getClass().getSimpleName());
		}
	}
	
	public void switchFrameInd(int index) {
		try {
			System.out.println("------------------------------------------------------------");
			driver.switchTo().frame(index);
			//updateStep("Switch to Frame with "+ index ,"Steps", "Pass");
		}catch(Exception e) {
			e.getMessage();
			//updateStep("Switch to Frame with " + index ,"Steps" , "Fail - Exception: "+"\n\t\t" + e.getClass().getSimpleName());
		}
	}
	
	
	/* This method tranfers the control to the frame present t the webelement  
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 * 
	 */
	public void switchFrame(WebElement element) {
		logger.info("--- SWITCH FRAME ---");
		try {
			driver.switchTo().frame(element);
			//updateStep("Switch to Frame","Steps", "Pass");
			
		}catch(Exception e) {
			e.getMessage();
			//updateStep("Switch to Frame" ,"Steps", "Fail - Exception: "+"\n\t\t" + e.getClass().getSimpleName());
		}
	}
	
	/* This method transfers the control from frames to the default frame
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	
	public void switchtoDefaultContent() throws IOException , InterruptedException {
		driver.switchTo().defaultContent();
		//updateStep("Switch to Default Content","Steps", "Pass");
	}
	
	/* This method wait or sleep till the element is available or present
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	
	public void waitForElementPresent(WebElement element , int time_in_ms) throws InterruptedException {
		int waittime = 0;
		Boolean bin_found = false;
		while (waittime < time_in_ms) {
			try {
				highlightElement(element);
				updateStep("Element Found","Steps","Pass");
				bin_found = true;
				return;
				
			}catch(NoSuchElementException e) {
				waittime = waittime + 1000 ;
			}catch(InterruptedException e) {
				e.getMessage();
			}
		}
		if(bin_found == false) {
			updateStep("Element Not Found","Steps","Pass");
		}
	}
	
	
	/* This method will wait for provided time in ms
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void wait(int time_in_ms) throws InterruptedException {
		Thread.sleep(time_in_ms);
	}
	
	
	/* This method is used for performing some operation when it is not working normally 
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void executeJScript(String action , WebElement element) {
		try {
			highlightElement(element);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript(action, element);
			unhighlight(element);
			updateStep("Javascipt Command" ,"Steps", "Pass");
		}catch(Exception e) {
			updateStep("Error in Executing javaScript","Steps","Fail - Exception: "+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	/* This method is used for clicking on an element when normal click operation is not working
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void executeJScriptClick( WebElement element) throws IOException , InterruptedException{
		try {
			highlightElement(element);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			//unhighlight(element);
			updateStep("Element Clicked" ,"Steps", "Pass");
		}catch(Exception e) {
			updateStep("Error in Executing javaScript","Steps","Fail - Exception: "+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	/* This method is used for getting the text of an element when normal GetText is not working
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	@SuppressWarnings("finally")
	public String executeJScriptGetText( WebElement element) throws IOException , InterruptedException {
		String text = null;
		try {
			highlightElement(element);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			text = (String) js.executeScript("return arguments[0].value;", element);
			unhighlight(element);
			//updateStep("JavaScript Command Executed" ,"Steps", "Pass");
		}catch(Exception e) {
			//updateStep("Error in Executing javaScript","Steps","Fail - Exception: "+"\n\t\t"+e.getClass().getSimpleName());
			text = "";
		}finally {
			System.out.println("Text Returned is: "+ text);
			return text ;
		}
	}
	
	public String GetText(WebElement ele) throws Exception  {
		//String text = null;
		System.out.println();
//		try {
			highlightElement(ele);
			String text = ele.getText();
			unhighlight(ele);
			return text;
			//updateStep("JavaScript Command Executed" ,"Steps", "Pass");
//		}catch(Exception e) {
//			e.getMessage();
//			//updateStep("Error in Executing javaScript","Steps","Fail - Exception: "+"\n\t\t"+e.getClass().getSimpleName());
//			//text = "";
//		}
	}
	/* This method returns the title of the webpage
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	@SuppressWarnings("finally")
	public String getTitle( WebElement element) throws IOException , InterruptedException {
		String title = null;
		try {
			title = driver.getTitle();
			updateStep("Get The Title" ,"Steps", "Pass");
		}catch(Exception e) {
			updateStep("Get The Title","Steps","Fail - Exception: "+"\n\t\t"+e.getClass().getSimpleName());
			title = "";
		}finally {
			return title ;
		}
		
	}
	
	/* This method returns true, if title of the webpage matches with the title of the provided data else false
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public Boolean assertTitle(String title) throws IOException , InterruptedException{
		try {
			if(driver.getTitle().contains(title)) {
				updateStep("Title matched"+title ,"Steps", "Pass");
				return true;
			}else {
				updateStep("Title mismatch- Expected :"+title + "Actual Title is :"+ driver.getTitle() ,"Steps" , "Fail");
				return false;
				
			}
		}catch(Exception e) {
			e.getMessage();
			updateStep("Error in getting page title","Steps", "Fail - Exception: "+"\n\t\t"+e.getClass().getSimpleName());
			return false;
		}
		
		
	}
	
	/* This method Takes us back by one page on the browser’s history.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void back() throws IOException , InterruptedException {
		try {
			driver.navigate().back();
			updateStep("navigate To Previous Page","Steps", "Pass");
		}catch(Exception e) {
			updateStep("Navigate To Previous Page","Steps", "Fail");
		}
	}
	
	/* This method forward by one page on the browser’s history
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void forward() throws IOException , InterruptedException {
		try {
			driver.navigate().forward();
			updateStep("navigate To Next Page","Steps", "Pass");
		}catch(Exception e) {
			updateStep("navigate To Next Page","Steps", "Fail");
		}
	}
	
	/* This method Refresh the current page
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void refresh() throws IOException , InterruptedException {
		try {
			driver.navigate().refresh();
			updateStep("Refresh Page","Steps", "Pass");
		}catch(Exception e) {
			updateStep("Refresh Page","Steps", "Fail");
		}
	}
	
	/* This method click on an element
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void click(WebElement ele , String desription) throws IOException , InterruptedException  {
		try {
			System.out.println("test inside click method");
			highlightElement(ele);
			System.out.println("test inside");
			//updateStep(desription,"Steps", "Pass");
			unhighlight(ele);
			ele.click();
		}catch(NoSuchElementException e) {
		//	updateStep(desription ,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			logger.error(desription +"Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			
		} catch(Exception e) {
		//	updateStep(desription,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			logger.error(desription + "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	/* This method type the text into the required field
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void type(WebElement ele , String Value , String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			ele.clear();
			ele.sendKeys(Value);
			//updateStep(description,"Steps", "Pass");
			//logger.info(description + ": pass");
			unhighlight(ele);
		}catch(Exception e) {
			//updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName()); 
		   // logger.error(description + "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			e.getMessage();
		}
	}
	
	
	/* The method selects the option by its visible option tag value
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void selectDropdownByVisibleText(WebElement ele,String Value,String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			Select se = new Select(ele);
			se.selectByVisibleText(Value);
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
		}catch(Exception e) {
			e.getMessage();
			e.getStackTrace();
			//updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	
	/* The method selects the option based on the VALUE attribute value of option tag
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void selectDropdownByVisibleValue(WebElement ele , String Value , String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			Select se = new Select(ele);
			se.selectByValue(Value);
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	
	/* The method deselects the option by Zero based INDEX value passed as an integer parameter
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void selectDropdownByIndex(WebElement ele , int index , String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			Select se = new Select(ele);
			se.selectByIndex(index);
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	
	/* The method returns true if text of the element equals to the provided text otherwise fale.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public Boolean assertTextEquals(WebElement ele , String expText) throws IOException , InterruptedException {
		String actText;
		try {
			highlightElement(ele);
			actText = ele.getText();
			if(actText.equalsIgnoreCase(expText)) {
				updateStep("Text matched :" + expText,"Steps", "Pass");
				unhighlight(ele);
				return true;
			}else {
				updateStep("Text not Matched"+ expText + "Actual : "+actText,"Steps", "Fail");
				return false ;
			}
		}catch(Exception e) {
			updateStep("Error while retrieving Text","Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			return false;
		}
		
	}
	
	
	/* The method returns true if text of the element contains or partially contains the provided text otherwise fale.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public Boolean assertTextContains (WebElement ele , String expText) throws IOException , InterruptedException {
		String actText ;
		try {
			highlightElement(ele);
			actText = ele.getText();
			if(actText.contains(expText)) {
				updateStep("Text Present :"+ expText,"Steps", "Pass");
				return true;
			}else {
				updateStep("Text not Present : Expected - "+ expText+"Actual :"+actText ,"Steps", "Fail");
				return false ;
			}
			
		}catch(Exception e) {
			updateStep("Error while Retrieving Text","Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			return false ;
		}
	}
	
	/* The method Moves the mouse to an offset from the top-left corner of the element using Actions class.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void mouseOver (WebElement ele , String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			Actions act = new Actions(driver);
			act.moveToElement(ele).build().perform();
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	
	/* This Method Clicks at the current mouse location using Actions class.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void clickAt(WebElement ele , String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			Actions act = new Actions(driver);
			act.click(ele).build().perform();
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			
		}
	}
	
	
	/* This Method Performs a double-click at the current mouse location using Actions class.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void doubleClick(WebElement ele , String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			Actions act = new Actions(driver);
			act.doubleClick(ele).build().perform();
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			
		}
	}
	
	/* This Method Performs a context-click at middle of the given element using Actions class.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void rightClick(WebElement ele , String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			Actions act = new Actions(driver);
			act.moveToElement(ele).contextClick().build().perform();
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			
		}
	}
	
	/* This convenience method performs click-and-hold at the location of the source element, moves to the location of the target element, then releases the mouse. using Actions class.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void dragAndDrop(WebElement ele1 , WebElement ele2 , String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele1);
			highlightElement(ele2);
			Actions act = new Actions(driver);
			act.dragAndDrop(ele1, ele2).build().perform();
			updateStep(description,"Steps", "Pass");
			unhighlight(ele1);
			unhighlight(ele2);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	/* This convenience method performs click-and-hold at the location of the source element, moves by a given offset, then releases the mouse using Actions class.
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void slideBy(WebElement ele , int x,int y, String description) throws IOException , InterruptedException {
		try {
			highlightElement(ele);
			Actions act = new Actions(driver);
			act.dragAndDropBy(ele, x, y).build().perform();
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
		}
	}
	
	/* This Method returns the current URL used by WebDriver
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public String getCurrentURL() {
		logger.info("--- Get The Current URL---");
		return driver.getCurrentUrl();
	}
	
	
	/* This Method returns the value of the given attribute as a String of the Web element
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public String getAttribute(WebElement ele , String attribute , String description) throws IOException , InterruptedException {
		logger.info("--- Get The Attribute Value ---");
		try {
			highlightElement(ele);
			updateStep(description,"Steps", "Pass");
			unhighlight(ele);
			return ele.getAttribute(attribute);
		}catch(Exception e) {
			updateStep(description,"Steps", "Fail - Exception :"+"\n\t\t"+e.getClass().getSimpleName());
			return null;
		}
	}
	
	/* This Method helps in uploading the files
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void fileUpload(WebElement ele , String path) throws IOException {
		File file = new File(path);
		path = file.getCanonicalPath();
		String cmd = null;
		if(driver instanceof FirefoxDriver) {
			cmd = ".\\Drivers\\geckodriver.exe";
		}
		if(driver instanceof ChromeDriver) {
			cmd = ".\\Drivers\\chromedriver.exe";
		}
		if(driver instanceof InternetExplorerDriver) {
			cmd = ".\\Drivers\\IEDriverServer.exe";
		}
		
		try {
			highlightElement(ele);
			updateStep("Click on Browse button for file upload","Steps", "Pass");
			ele.click();
			unhighlight(ele);
			ProcessBuilder pb = new ProcessBuilder(cmd,path);
			pb.start();
		}catch(Exception e) {
			updateStep("Exception while clicking Browse Button","Steps", "Fail - Exception :\"+\"\\n\\t\\t\"+e.getClass().getSimpleName()");
		}
	}
	
	
	/* This Method help in uploading files using robot i.e keyboard event
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void fileUploadUsingRobot(String fileName) throws AWTException , InterruptedException {
		
		StringSelection ss = new StringSelection(fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	/* This Method help in pressing Escape keys (Esc) from keyboard using Ations class
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void pressEscape() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	
	/* This Method help in pressing Enter keyword from keyboard, keyboard event using Ations class
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void pressEnter() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}
	
	/*
	 * public void endReport() { System.out.
	 * println("################# End Of Execution #######################");
	 * generateMethodInfo(); super endOfTestCase = true; }
	 */
	
	/*
	 * public void generateTestStep() { Log.info("After Method of "+ Browser);
	 * reportPathBrowser = reportPath ;
	 * 
	 * @SupressWarnings("unchecked") ArrayList<String[]> newList =
	 * (ArrayList<String[]>) stepsDetails.clone();
	 * System.out.println("stepsDetails reportPathBrowser : ----------------> "+
	 * reportPathBrowser); testDetails.add(newList);
	 * System.out.println("Array test case details --------->"+ testDetails);
	 * serielNo = 1;
	 * 
	 * }
	 */
	
	
	/* This Method returns the desired key from buffer storage
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public String readFromBuffer(String key) {
		String value = "";
		try {
		//	value = Buffer.getBuffer(key);
			
		}catch(Exception e) {
			updateStep("Exception while reading the key from buffer"+ key,"Steps", "Fail");
		}
		return value;
	}
	
	
	 /* public String writeIntoBuffer(String key ,String value) { 
		try { 
			  value = Buffer.setBuffer(key,value);
	  
	   }catch(Exception e) {
	  updateStep("Exception while writting the key value pair from buffer"+ key + "," + value ,"Steps", "Fail"); } 
	  }
	 */
	
	
	/* This Method returns the random number between a range
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public int generateRandomNumber(int range , int startNum) {
		Random rn = new Random();
		int val = rn.nextInt() + startNum ;
		return val;
	}
	
	/* This Method Types from keyboard using robot i.e keyboard event
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void typeusingRobot(String fileName) throws AWTException , InterruptedException {
		StringSelection ss = new StringSelection(fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
				
	}
	
	/* This Method help in press Tab from keyboard using robot i.e keyboard event
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void pressTabUsingRobot() throws  AWTException , InterruptedException  {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
	}
	
	/* This Method help in press Tab using Actions class
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void pressTAB() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
	}
	
	/* This Method help in press Enter using robot i.e keyboard event
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public void pressEnterUsingRobot() throws AWTException , InterruptedException{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	/* This Method returns new file from the path
	 * 
	 * @CreatedBy - Debasis
	 * @CreatedDate - 21 Aug 2019
	 * @UpdatedBy - NA
	 * @ModifiedDate - NA
	 * 
	 */
	public String getTheNewestFILE(String filepath , String ext ) {
		File theNewestFile = null;
		File dir = new File(filepath);
		FileFilter filefilter = new WildcardFileFilter("*."+ext);
		File[] files = dir.listFiles(filefilter);
		if(files.length>0) {
			Arrays.sort(files,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}
		System.out.println(theNewestFile.getName());
		return theNewestFile.getName();
	}
	
	public String PrintData(String data) {
		System.out.println(data);
		return data;
	}


}
