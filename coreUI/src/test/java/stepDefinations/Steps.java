package stepDefinations;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.BaseClass;


@Test
public class Steps extends BaseClass {

	ExtentTest info = null;
	// Properties cnfgProp = new Properties();
	
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

	@Before()
	public void setUp() throws IOException, Exception {
		PropertyConfigurator.configure("Log4j.properties");
		cnfgProp = new Properties();
		FileInputStream ConfigProf = new FileInputStream("config.properties");
		cnfgProp.load(ConfigProf);
		String brwsr = cnfgProp.getProperty("browser");
		String URL = cnfgProp.getProperty("URL");
		System.out.println(cnfgProp.getProperty("chromepath"));

		if (brwsr.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", cnfgProp.getProperty("chromepath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("browser is chrome");
			Thread.sleep(300);
			driver.get(URL);
			Thread.sleep(500);
			
		} else if (brwsr.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", cnfgProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("browser is Firefox");
			Thread.sleep(500);
			driver.get(URL);
			Thread.sleep(200);
			
		} else if (brwsr.equals("ie")) {
			System.setProperty("webdriver.ie.driver", cnfgProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			System.out.println("browser is IE");
			Thread.sleep(500);
			
			driver.get(URL);
			Thread.sleep(200);
			
		} else {
			System.setProperty("webdriver.chrome.driver", cnfgProp.getProperty("chromepath"));
			driver = new ChromeDriver();
			System.out.println("browser is chrome");
			Thread.sleep(500);
			driver.get(URL);
			Thread.sleep(200);
		}
	

	}

	
	@After
	public void closeBrowser(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
			scenario.write("Scenario Failed..");

			//info.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +" - Test Case Failed", ExtentColor.RED));
			 

			
			 File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			  BufferedImage img = ImageIO.read(screen); File filetest =
			  Paths.get(".").toAbsolutePath().normalize().toFile(); ImageIO.write(img,
			  "png", new File(filetest + "\\Screenshots\\" + "Test01.png"));
			  info.info("Details of " + "Test screenshot", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") +
			  "\\Screenshots\\" + "Test01.png") .build());
			 

		} else {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
			scenario.write("Scenario Passed..");
		}
		driver.close();
		driver.quit();
	}

	
	
	
	/*                     PO_Upload                                    */

	@Given("^Select \"([^\"]*)\" from Client drop$")
	public void select_from_Client_drop(String ClientName) throws Throwable {
		Thread.sleep(1000);
		super.initializeObjects();
		cm.switchFrameInd(0);
		Thread.sleep(500);
		cm.selectDropdownByVisibleText(poUpload.clntDrpdwn, ClientName, "description");
		Thread.sleep(5000);
		

	}

	@Then("^Click on Admin Module$")
	public void click_on_Admin_Module() throws Throwable {
		super.initializeObjects();
		Thread.sleep(5000);
		cm.Click(poUpload.adminModule);
		Thread.sleep(2000);
		cm.switchtoDefaultContent();
		
	}

	@Then("^Click on New File Upload$")
	public void click_on_New_File_Upload() throws Throwable {
		super.initializeObjects();
		Thread.sleep(2000);
		cm.switchFrameInd(1);
		Thread.sleep(5000);
		cm.Click(poUpload.optNewFileUpld);
		System.out.println("New file Upload clicked");
		cm.switchtoDefaultContent();
		Thread.sleep(5000);
		System.out.println("Click on New File Upload_PO");
	}
	
	@Then("^Upload the file \"([^\"]*)\"$")
	public void upload_the_file(String Fpath) throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		poUpload.browseFld.sendKeys(Fpath);
		Thread.sleep(1500);
		System.out.println("Upoad file selected");
		cm.Click(poUpload.butttnUpload);
		System.out.println("Upload the PO file_PO");
		Thread.sleep(5000);
	}

	@Then("^Verify success message \"([^\"]*)\"$")
	public void verify_success_message(String validationMessage) throws Throwable {
		super.initializeObjects();
		String upldConfirmMsg = driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div[1]/table/tbody/tr/td[1]/div")).getText();
		Thread.sleep(2500);
		if(upldConfirmMsg.contentEquals(validationMessage)) {
			System.out.println("Success Message - Verrified");
		}else {
			System.out.println("Success Message - Verrification Failed");
		}
		
		System.out.println("message verified");
		cm.switchtoDefaultContent();
		Thread.sleep(1500);
		System.out.println("Verify success message <ValidationMessage>_PO");
	}

	@Then("^Click on Upload File List available on the side bar$")
	public void click_on_Upload_File_List_available_on_the_side_bar() throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("treeFrame");
		Thread.sleep(3500);
		cm.Click(poUpload.upldFileSts);
		Thread.sleep(3500);
		System.out.println("Clicked on upload file list");
		cm.switchtoDefaultContent();
		System.out.println("Click on Upload File List available on the side bar_PO");
	}
	
	@Then("^Select \"([^\"]*)\" from File Type drop down$")
	public void select_from_File_Type_drop_down(String FileType) throws Throwable {
		super.initializeObjects();
		Thread.sleep(2500);
		cm.switchFrameID("rightFrame");
		Thread.sleep(2500);
		cm.selectDropdownByVisibleText(poUpload.filetypepeDrpDwn, FileType, "description");
		Thread.sleep(5000);
		System.out.println("Select PO from File Type drop down_PO");
	}

	@And("^Enter File Name \"([^\"]*)\"$")
	public void enter_File_Name(String FileName) throws Throwable {
		Thread.sleep(3000);
		poUpload.setFileName(FileName);
		Thread.sleep(1500);
		System.out.println("Enter File Name <FileName>_PO");
		
	}

	@Then("^Click on Search$")
	public void click_on_Search() throws Throwable {
		super.initializeObjects();
		System.out.println("+++++++++++++Click on Search_PO++++++++++++++++++=");
		Thread.sleep(1500);
		cm.Click(poUpload.buttnSearch);
		Thread.sleep(3500);
	}

	@Then("^Verify the status \"([^\"]*)\" of the uploaded file \"([^\"]*)\"$")
	public void verify_the_status_of_the_uploaded_file(String FileName, String Status) throws Throwable {
		Thread.sleep(5000);
		String upldStatus = cm.GetText(poUpload.stsfldData);
		Thread.sleep(5000);
		String upldFileName = cm.GetText(poUpload.searchRsltFileName);// driver.findElement(By.id("gvUploadFIleList_lblFileName_0")).getText();
		System.out.println(upldFileName);
		if(upldFileName.contentEquals(FileName)) {
			System.out.println("upldFileName verified");
		}else {
			System.out.println("upldFileName verification failed");
		}
		System.out.println("----------upldFileName------------------");
		Thread.sleep(4000);
		if(upldStatus.contentEquals(Status)) {
			System.out.println("Status verified");
		}else {
			System.out.println("Status mismatch");
		}
		cm.switchtoDefaultContent();
		Thread.sleep(1500);
		System.out.println("Verify the status <Status> of the uploaded PO file <FileName>_PO");
	}

	@Then("^Click on BaseData$")
	public void click_on_BaseData() throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("menuFrame");
		System.out.println("Before Basedata");
		cm.Click(poUpload.baseDataModule);
		System.out.println("After Admin");
		Thread.sleep(5000);
		cm.switchtoDefaultContent();
		System.out.println("Click on BaseData_PO");
	}

	@Then("^Search for the Number \"([^\"]*)\"$")
	public void search_for_the_Number(String Number) throws Throwable {
		
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(5000);
		poUpload.setPO(Number);
		Thread.sleep(2000);
		System.out.println("++++++++++++++++Po number entered+++++++++++++++++++++++++");
		cm.Click(poUpload.buttnSearch);
		System.out.println("Search for the PO <PONumber>_PO");
		Thread.sleep(2500);
		cm.switchtoDefaultContent();
		Thread.sleep(2500);
	}

	@Then("^Verify the PO Details in the Result grid \"([^\"]*)\"$")
	public void verify_the_PO_Details_in_the_Result_grid(String Number) throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(5000);
		String capturedPONumber = cm.GetText(poUpload.ftchPoRwData);
		//String capturedPONumber = driver.findElement(By.id("gvSo_lbtnSoNumber_0")).getText();
		Thread.sleep(4500);		
		System.out.println(capturedPONumber);
		Thread.sleep(5500);
		if(capturedPONumber.equalsIgnoreCase(Number)) {
			System.out.println("Number Verification - Passed");
		}else {
			System.out.println("Number Verification - Failed");
		}
		
		cm.switchtoDefaultContent();
		Thread.sleep(1500);
		
	}

	
	
	/*                        Start SO_Upload                               */


	@Then("^Select the SO File Type_SO$")
	public void select_the_SO_File_Type_SO() throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(2500);
		cm.Click(soUpload.rbttnSO);
		Thread.sleep(1500);
		System.out.println("SO file type selected");
		cm.switchtoDefaultContent();
		Thread.sleep(5000);
	}

	@Then("^Click on SO View for SO Upload verification_SO$")
	public void click_on_SO_View_for_SO_Upload_verification_SO() throws Throwable {
		super.initializeObjects();
		System.out.println("so view tag");
		cm.switchFrameID("treeFrame");
		Thread.sleep(5000);
		cm.click(soUpload.soViewPage, "Clicked on so view page");
		Thread.sleep(2500);
		cm.switchtoDefaultContent();  
	}
		

	
	@And("^Search for the SO Number \"([^\"]*)\"$")
	public void search_for_the_SO_Number(String Number) throws Throwable {
		
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(10000);
		cm.type(soUpload.soTxtBox,Number,"So number entered");
		Thread.sleep(5000);
		cm.Click(soUpload.buttnSearch);
		System.out.println("Search for the PO <PONumber>_PO");
		Thread.sleep(2500);
		cm.switchtoDefaultContent();
	}


	@Then("^Verify the SO Details in the Result grid \"([^\"]*)\"$")
	public void verify_the_SO_Details_in_the_Result_grid(String Number) throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(5000);
		String capturedSONumber = cm.GetText(soUpload.ftchRowData);
		Thread.sleep(4500);	
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(capturedSONumber);
		System.out.println(Number);
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		if(capturedSONumber.equalsIgnoreCase(Number)) {
			System.out.println("PoNumber Verification - Passed");
		}else {
			System.out.println("PoNumber Verification - Failed");
		}
		cm.switchtoDefaultContent();
		Thread.sleep(1500);
		
	}
	

	/*                   LP Upload                     */
	
	@Then("^Select the LP File Type_LP$")
	public void select_the_LP_File_Type_LP() throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(5000);
		cm.Click(lpUpload.rbttnLP);
		Thread.sleep(500);
		cm.switchtoDefaultContent();
		Thread.sleep(5000);
	}
	
	
	@Then("^Click on LP View for LP Upload verification_LP$")
	public void click_on_LP_View_for_LP_Upload_verification_LP() throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("treeFrame");
		Thread.sleep(5000);
		cm.click(lpUpload.lpViewPage, "Clicked on LP View");
		Thread.sleep(5000);
		cm.switchtoDefaultContent();
		}
	
	@Then("^Search the PO \"([^\"]*)\" for LP Upload verification_LP$")
	public void search_the_PO_for_LP_Upload_verification_LP(String Number) throws Throwable {
		super.initializeObjects();
		Thread.sleep(5000);
		cm.switchFrameID("rightFrame");
		Thread.sleep(3000);
		lpUpload.setLP(Number);
		Thread.sleep(2000);
		cm.Click(lpUpload.ftchRowData);
		Thread.sleep(1000);
		cm.switchtoDefaultContent();
	}

	
	@Then("^Verify the LP Details in the Result grid \"([^\"]*)\"$")
	public void verify_the_LP_Details_in_the_Result_grid(String Number) throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(5000);
		String capturedLPNumber = cm.GetText(lpUpload.ftchLPRwDataLP);
		Thread.sleep(4500);	
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(capturedLPNumber);
		System.out.println(Number);
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		if(capturedLPNumber.equalsIgnoreCase(Number)) {
			System.out.println("Number Verification - Passed");
		}else {
			System.out.println("Number Verification - Failed");
		}
		cm.switchtoDefaultContent();
		Thread.sleep(1500);
		
	}

	
	
	

	/*              Start SccanIB Latest                             */


	@Then("^Select the Scan data File Type_ScanIB$")
	public void select_the_Scan_data_File_Type_ScanIB() throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(2000);
		cm.Click(sdIBUpload.rbttnScanData);
		Thread.sleep(500);
		cm.switchtoDefaultContent();
		Thread.sleep(2000);
	}	
		


	@Then("^Click on ScanData Overview for ScanIB Upload verification_ScanIB$")
	public void click_on_ScanData_Overview_for_ScanIB_Upload_verification_ScanIB() throws Throwable {
		super.initializeObjects();
		cm.switchFrameID("treeFrame");
		Thread.sleep(3000);
		cm.click(sdIBUpload.scanDataOverviewPage, "Clicked on scanData Overview Page");
		Thread.sleep(2000);
		cm.switchtoDefaultContent();
	
	}

	@Then("^Search the SO \"([^\"]*)\" for ScanIB Upload verification_ScanIB$")
	public void search_the_SO_for_ScanIB_Upload_verification_ScanIB(String Number) throws Throwable {
		super.initializeObjects();
		Thread.sleep(3000);
		cm.switchFrameID("rightFrame");
		Thread.sleep(2000);
		sdIBUpload.setsdIBSONumber(Number);
		Thread.sleep(2000);
		cm.Click(sdIBUpload.sdIBGresult);
		Thread.sleep(500);
		cm.switchtoDefaultContent();

	}



	@Then("^Verify the ScanData Overview Details in the Result grid \"([^\"]*)\"$")
	public void verify_the_ScanData_Overview_Details_in_the_Result_grid(String Number) throws Throwable {
			
		super.initializeObjects();
		cm.switchFrameID("rightFrame");
		Thread.sleep(3000);
		String capturedsdIBNumber = cm.GetText(sdIBUpload.ftchLPRwData);
		Thread.sleep(2500);		
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(capturedsdIBNumber);
		System.out.println(Number);
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		if(capturedsdIBNumber.equalsIgnoreCase(Number)) {
			System.out.println("Number Verification - Passed");
		}else {
			System.out.println("Number Verification - Failed");
		}
		
		cm.switchtoDefaultContent();
		Thread.sleep(1500);
	}

		
	  /*                             Start ScanOB                             */

	
		@Then("^Select the Scan data File Type_ScanOB$")
		public void select_the_Scan_data_File_Type_ScanOB() throws Throwable {
			super.initializeObjects();
			cm.switchFrameID("rightFrame");
			Thread.sleep(5000);
			cm.Click(sdOBUpload.rbttnScanDataOB);
			System.out.println("SO file type selected");
			cm.switchtoDefaultContent();
			Thread.sleep(5000);
		}



		@Then("^Click on ScanData Overview for ScanOB Upload verification_ScanOB$")
		public void click_on_ScanData_Overview_for_ScanOB_Upload_verification_ScanOB() throws Throwable {
			super.initializeObjects();
			cm.switchFrameID("treeFrame");
			Thread.sleep(5000);
			cm.click(sdOBUpload.scanDataOverviewPage, "Clicked on scanData Overview Page");
			Thread.sleep(5000);
			cm.switchtoDefaultContent();
	    }

		@Then("^Search the SO \"([^\"]*)\" for ScanOB Upload verification_ScanOB$")
		public void search_the_SO_for_ScanOB_Upload_verification_ScanOB(String Number) throws Throwable {
			super.initializeObjects();
			Thread.sleep(5000);
			cm.switchFrameID("rightFrame");
			Thread.sleep(5000);
			sdOBUpload.setsdOBSONumber(Number);
			System.out.println("PO number entered");
			Thread.sleep(5000);
			cm.Click(sdOBUpload.sdOBGresult);
			cm.switchtoDefaultContent();

		}

	
		@Then("^Verify the ScanData Overview details in Result grid \"([^\"]*)\" for ScanOB upload verification_ScanOB$")
		public void verify_the_ScanData_Overview_details_in_Result_grid_for_ScanOB_upload_verification_ScanOB(String Number) throws Throwable {
			super.initializeObjects();
			System.out.println("Verify the lp details");
			cm.switchFrameID("rightFrame");
			Thread.sleep(5000);
			String capturedsdOBNumber = cm.GetText(sdOBUpload.ftchsdOBRwData);
			Thread.sleep(4500);		
			System.out.println(capturedsdOBNumber);
			Thread.sleep(5500);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			System.out.println(capturedsdOBNumber);
			System.out.println(Number);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			if(capturedsdOBNumber.equalsIgnoreCase(Number)) {
				System.out.println("Number Verification - Passed");
			}else {
				System.out.println("Number Verification - Failed");
			}
			
			cm.switchtoDefaultContent();
			Thread.sleep(1500);
		}

			
		/*                       CS View                                       */
	
		@Then("^Select the CS File Type_CS$")
		public void select_the_CS_File_Type_CS() throws Throwable {
			 	super.initializeObjects();
				cm.switchFrameID("rightFrame");
				Thread.sleep(5000);
				cm.click(csUpload.rbttnCS, "click on cs view radio button");
				System.out.println("SO file type selected");
				cm.switchtoDefaultContent();
				Thread.sleep(5000);
	  }
		 
		@Then("^Click on CS View for CS Upload verification_CS$")
		public void click_on_CS_View_for_CS_Upload_verification_CS() throws Throwable {
			super.initializeObjects();
			cm.switchFrameID("treeFrame");
			cm.click(csUpload.csViewPage, "Click on CS View Page");
			System.out.println("CS View Selected");
			cm.switchtoDefaultContent(); 
		}
		
		@Then("^Search the SO \"([^\"]*)\" for CS Upload verification_CS$")
		public void search_the_SO_for_CS_Upload_verification_CS(String SONumber) throws Throwable {
		 super.initializeObjects();
		 cm.switchFrameID("rightFrame");
		 Thread.sleep(5000);
		 csUpload.setSOcsNumber(SONumber);
		 Thread.sleep(2000);
		 cm.click(csUpload.buttnSearch, "Click on search");
		 System.out.println("Searched"); 
		 Thread.sleep(20000);
		}
		
		
		@Then("^Verify the SO Number against the CS Number in Result grid \"([^\"]*)\"\"([^\"]*)\" for CS upload verification$")
		public void verify_the_SO_Number_against_the_CS_Number_in_Result_grid_for_CS_upload_verification(String SONumber, String CSNumber) throws Throwable { 
			super.initializeObjects();
			System.out.println("Verify the cs details");
			cm.switchFrameID("rightFrame");
			Thread.sleep(3000);
			String capturedCSUploadNumber = cm.GetText(csUpload.csResult);
			Thread.sleep(1500);	
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			System.out.println(capturedCSUploadNumber);
			System.out.println(CSNumber);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			if(capturedCSUploadNumber.equalsIgnoreCase(CSNumber)) {
				System.out.println("CS Number Verification - Passed");
			}else {
				System.out.println("CS Number Verification - Failed");
			}
			
			Thread.sleep(2000);
			String capturedSOUploadNumber = cm.GetText(csUpload.soResult);
			Thread.sleep(500);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			System.out.println(capturedSOUploadNumber);
			System.out.println(SONumber);
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			if(capturedSOUploadNumber.equalsIgnoreCase(SONumber)) {
				System.out.println("SO Number Verification - Passed");
			}else {
				System.out.println("SO Number Verification - Failed");
			}
			cm.switchtoDefaultContent();
			Thread.sleep(1500);    
		}
		
}
