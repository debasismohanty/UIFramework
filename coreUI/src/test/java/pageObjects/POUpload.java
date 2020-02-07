package pageObjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class POUpload {
		public WebDriver ldriver;
		
		public POUpload(WebDriver rdriver) {
			ldriver = rdriver ;
			PageFactory.initElements(rdriver,this);
		}
		
		@FindBy(id="ddlClient")
		@CacheLookup
		public WebElement clntDrpdwn;//--1  

		@FindBy(id = "lbtnAdmin")
		@CacheLookup
		public WebElement adminModule;
		
		@FindBy(id="sd18")
		@CacheLookup
		public WebElement optNewFileUpld;
		
		@FindBy(id="rbtnPO")
		@CacheLookup
		public WebElement rbttnPO;
		
		@FindBy(xpath="/html/body/form/div[3]/div[3]/div[1]/table/tbody/tr[2]/td/input[@type='file']")
		@CacheLookup
		public WebElement filetxtfld;//--2
		
		@FindBy(id="btnUpload")
		@CacheLookup
		public WebElement butttnUpload;
		
		@FindBy(xpath="/html/body/form/div[3]/div[3]/div[1]/table/tbody/tr[2]/td/input[@type='file']")
		@CacheLookup
		public WebElement browseFld;
		
		@FindBy(id="normalMsg")
		@CacheLookup
		public WebElement sMessage;//--3
		
		@FindBy(id="sd17")
		@CacheLookup
		public WebElement optUpldFileList;
		
		@FindBy(id="ddlXMLFileType")
		@CacheLookup
		public WebElement filetypepeDrpDwn;//--4
		
		@FindBy(id="txtFileName")
		@CacheLookup
		public WebElement fileNameTxt;
		
		@FindBy(id="btnSearch")
		@CacheLookup
		public WebElement buttnSearch;
		
		@FindBy(id="gvUploadFIleList_lblFileName_0")//--5
		@CacheLookup
		public WebElement searchRsltFileName;
		
		@FindBy(xpath="/html/body/form/div[3]/div[2]/div/div[2]/div[15]/div[1]/a")//--6
		@CacheLookup
		public WebElement upldFileSts;
		
		@FindBy(xpath="/html/body/form/div[3]/div[3]/div[1]/div[1]/table/tbody/tr/td[1]/div")
		@CacheLookup
		public WebElement upldStsMsgVld;
		
		
		@FindBy(id="lbtnBaseData")
		@CacheLookup
		public WebElement baseDataModule;
		
		@FindBy(id="txtPO")
		@CacheLookup
		public WebElement poTxtBoxes;
		
		@FindBy(id="gvUploadFIleList_lblStatus_0")
		@CacheLookup
		public WebElement stsfldData;
		
		@FindBy(id="gvPo")//--7
		@CacheLookup
		public WebElement poResult;    
		
		
		
		
		@FindBy(id="gvPo_lbtnPoNumber_0")//--7
		@CacheLookup
		public WebElement ftchPoRwData;

		
		
		public void selectDropdownByVisibleText(WebElement ele,String value) {
			
			Select se = new Select(ele);
			se.selectByVisibleText(value);
			
			
		}
		
		public  void ClickOnAdminModule()
		{
		adminModule.click();
		System.out.println("Clicked on Admin Module");
		}
		
		public void selectNewFileUpload()
		{
			optNewFileUpld.click();
			System.out.println("New File Upload option selected");
		}
		
		public void selectPORButton()
		{
			rbttnPO.click();
			System.out.println("PO File Type radio button selected");
		}
		public void selectfiletextfield() {
			filetxtfld.sendKeys("D:\\ESSPL_Selenium_Projects\\coreUI\\FileUploads\\L_O_LNS_PO.A877CB7D.A015A041.xml");
			System.out.println("File selected");
		}
		
	public void clickUploadButton() {
		butttnUpload.click();
		System.out.println("Upload button clicked");
	}
		
		public void selectUploadFileList()
		{
			optUpldFileList.click();
			System.out.println("Upload file list option selected");
		}
		
		public void setFileName(String FileName)
		{
			fileNameTxt.clear();
			fileNameTxt.sendKeys(FileName);
			System.out.println("Value entered in File Name search field");
		}
		
		public void clkSearch()
		{
			buttnSearch.click();
			System.out.println("Seacrh button clicked");
		}
		
		public void selBaseData()
		{
			baseDataModule.click();
			System.out.println("BaseData Module selected");
		}
		
		public void setPO(String PONumber)
		{
			System.out.println("+++++++++set po field+++++++++++++++++");
			poTxtBoxes.clear();
			poTxtBoxes.sendKeys(PONumber);
			System.out.println("Value entered in PO search field");
		}
		
		public void clkPOSearch()
		{
			buttnSearch.click();
			System.out.println("Seacrh button clicked");
		}
	}
