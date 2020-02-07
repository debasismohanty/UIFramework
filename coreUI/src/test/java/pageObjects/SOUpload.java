package pageObjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class SOUpload {
		public WebDriver ldriver;
		
		public SOUpload(WebDriver rdriver) {
			ldriver = rdriver ;
			PageFactory.initElements(rdriver,this);
		} 

		@FindBy(xpath="//*[@id=\"lbtnAdmin\"]")
		@CacheLookup
		public WebElement adminModule;
		
		@FindBy(id="sd18")
		@CacheLookup
		public WebElement optNewFileUpld;
		
		@FindBy(id="rbtnSO")
		@CacheLookup
		public WebElement rbttnSO;
		
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
		public WebElement upldFileStatus;
		
		@FindBy(id="lbtnBaseData")
		@CacheLookup
		public WebElement baseDataModule;
		
		@FindBy(id="sd3")
		@CacheLookup
		public WebElement soViewPage;
		
		@FindBy(id="txtSO")
		@CacheLookup
		public WebElement soTxtBox;
		
//		@FindBy(id="btnSearch")
//		@CacheLookup
//		public WebElement searchBtn;
		
		@FindBy(id="gvSo")
		@CacheLookup
		public WebElement soResult;
		
		@FindBy(id="tree")
		@CacheLookup
		public WebElement leftbarIframe;
		
		
		@FindBy(xpath="/html/body/form/div[3]/div[5]/div/div/table/tbody/tr[4]/td[2]/a")
		@CacheLookup
		public WebElement ftchRowData;
		
		
		
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
			rbttnSO.click();
			System.out.println("SO File Type radio button selected");
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
		
		public void selSOView()
		{
			soViewPage.click();
			System.out.println("SO View page selected");
		}
		
		public void setSO(String SONumber)
		{
			soTxtBox.clear();
			soTxtBox.sendKeys(SONumber);
			System.out.println("Value entered in PO search field");
		}
		
		public void clkSOSearch()
		{
			buttnSearch.click();
			System.out.println("Seacrh button clicked");
		}
	}
