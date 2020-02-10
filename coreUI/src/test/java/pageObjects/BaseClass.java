package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.testautomation.Listeners.ExtentReporterListener;

import utiilities.CommonUtilities;

public class BaseClass {
	
	public static Properties cnfgProp;
	//public static Properties OR = new Properties();
	public static Logger logger = Logger.getLogger("coreUI");
	public static WebDriverWait wait;
	public FileInputStream fis;
	public  WebDriver driver = null;
	public CommonUtilities cm;
	public ExtentReporterListener erL;
	public POUpload poUpload;
	public SOUpload soUpload;
	public LPUpload lpUpload;
	public ScanDataIBUpload sdIBUpload;
	public ScanDataOBUpload sdOBUpload;
	public CSUpload csUpload;
	

	public void initializeObjects() throws IOException, Exception {
		
		cm = new CommonUtilities(driver);
		erL = new ExtentReporterListener();
		poUpload=new POUpload(driver);
		soUpload = new SOUpload(driver);
		lpUpload = new LPUpload(driver);
		sdIBUpload = new ScanDataIBUpload(driver);
		sdOBUpload = new ScanDataOBUpload(driver);
		csUpload = new CSUpload(driver);
	
	}
	
	
	
	
	}
	
	

