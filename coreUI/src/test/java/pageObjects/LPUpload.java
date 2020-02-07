package pageObjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LPUpload {
		public WebDriver ldriver;
		
		public LPUpload(WebDriver rdriver) {
			ldriver = rdriver ;
			PageFactory.initElements(rdriver,this);
		}
		
		@FindBy(id="ddlClient")
		@CacheLookup
		public WebElement clntDrpdwn;  

		@FindBy(id="lbtnAdmin")
		@CacheLookup
		public WebElement adminModule;
		
		@FindBy(id="sd18")
		@CacheLookup
		public WebElement optNewFileUpld;
		
		@FindBy(id="rbtnLPFile")
		@CacheLookup
		public WebElement rbttnLP;
		
		@FindBy(id="btnUpload")
		@CacheLookup
		public WebElement butttnUpload;
		
		@FindBy(id="normalMsg")
		@CacheLookup
		public WebElement sMessage;
		
		@FindBy(id="sd17")
		@CacheLookup
		public WebElement optUpldFileList;
		
		@FindBy(id="ddlXMLFileType")
		@CacheLookup
		public WebElement filetypepeDrpDwn;
		
		@FindBy(id="txtFileName")
		@CacheLookup
		public WebElement fileNameTxt;
		
		@FindBy(id="btnSearch")
		@CacheLookup
		public WebElement buttnSearch;
		
		@FindBy(id="gvUploadFIleList_lblFileName_0")
		@CacheLookup
		public WebElement searchRsltFileName;
		
		@FindBy(id="gvUploadFIleList_lblStatus_0")
		@CacheLookup
		public WebElement upldFileSts;
		
		@FindBy(id="lbtnBaseData")
		@CacheLookup
		public WebElement baseDataModule;
		
		@FindBy(id="sd4")
		@CacheLookup
		public WebElement lpViewPage;
		
		@FindBy(xpath="/html/body/form/div[4]/div[4]/div[1]/table/tbody/tr[1]/td[3]/input")
		@CacheLookup
		public WebElement lpTxtBox;
		
		@FindBy(id="btnSearch")
		@CacheLookup
		public WebElement searchBtn;
		
		@FindBy(id="gvLp_lbtnSo_0")
		@CacheLookup
		public WebElement lpResult;   
		
		
		@FindBy(id="btnGroupSearch")
		@CacheLookup
		public WebElement ftchRowData;
		
		@FindBy(id="gvGroupLP_lbtnSoGroup_0")
		@CacheLookup
		public WebElement ftchLPRwData;
				
		@FindBy(id="gvGroupLP_lbtnPoGroup_0")
		@CacheLookup
		public WebElement ftchLPRwDataLP;
		
		public void selectAdmin()
		{
			adminModule.click();
			System.out.println("Admin Module selected");
		}
		
		public void selectNewFileUpload()
		{
			optNewFileUpld.click();
			System.out.println("New File Upload option selected");
		}
		
		public void selectPORButton()
		{
			rbttnLP.click();
			System.out.println("LP File Type radio button selected");
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
		
		public void selLPView()
		{
			lpViewPage.click();
			System.out.println("SO View page selected");
		}
		
//		public void setPO(String PONumber)
//		{
//			poTxtBox.clear();
//			poTxtBox.sendKeys(PONumber);
//			System.out.println("Value entered in PO search field");
//		}
		
		public void setLP(String Number)
		{
			lpTxtBox.clear();
			lpTxtBox.sendKeys(Number);
			System.out.println("Value entered in PO search field");
		}
		
		
		public void clkLPDtlSearch()
		{
			searchBtn.click();
			System.out.println("Seacrh button clicked");
		}
	}
