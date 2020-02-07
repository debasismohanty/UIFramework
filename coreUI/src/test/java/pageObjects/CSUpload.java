package pageObjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CSUpload {
		public WebDriver ldriver;
		
		public CSUpload(WebDriver rdriver) {
			ldriver = rdriver ;
			PageFactory.initElements(rdriver,this);
		}
		
		@FindBy(id="ddlClient")
		@CacheLookup
		public WebElement clntDrpdwn;  

		@FindBy(id="lbtnAdmin")
		@CacheLookup
		public WebElement adminModule;
		
		@FindBy(id="sd22")
		@CacheLookup
		public WebElement optNewFileUpld;
		
		@FindBy(id="rbtnCSFile")
		@CacheLookup
		public WebElement rbttnCS;
		
		@FindBy(id="btnUpload")
		@CacheLookup
		public WebElement butttnUpload;
		
		@FindBy(id="normalMsg")
		@CacheLookup
		public WebElement sMessage;
		
		@FindBy(id="sd21")
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
		
		@FindBy(id="sd5")
		@CacheLookup
		public WebElement csViewPage;
		
		@FindBy(id="txtSO")
		@CacheLookup
		public WebElement soTxtBox;
		
		@FindBy(id="btnSearch")
		@CacheLookup
		public WebElement searchBtn;
		
		@FindBy(id="gvCs_lbtnSo_0")
		@CacheLookup
		public WebElement soResult;
		
		@FindBy(id="gvCs_lblCS_0")
		@CacheLookup
		public WebElement csResult;
		
		
		@FindBy(id="gvGroupView_lblSO_0")
		@CacheLookup
		public WebElement csSOResult;
		
		@FindBy(id="gvGroupView_lblPO_0")
		@CacheLookup
		public WebElement csPOResult;
		
		
		
		//Click on Admin Module	
		public void clkOnAdminModule() {
			adminModule.click();
		}
		
		//Click on New File Upload menu
		public void clkOnNewFileUpload() {
			optNewFileUpld.click();
		}
		//Click on Upload button
		public void clkOnButtonUpld() {
			butttnUpload.click();
		}
		// Then Select the CS File Type
		public void clkOnFileType() {
			rbttnCS.click();
		}
		//Click on Upload new File List available on the side bar
		public void clkOnUpldFileList() {
			optUpldFileList.click();
		}
		// Then Enter the CS File Name <FileName>
		public void setFileName(String fileName) {
			fileNameTxt.clear();
			fileNameTxt.sendKeys(fileName);
		}
		//Click on Search
		public void clkOnSearchButton() {
			buttnSearch.click();
		}
		
		//Click on BaseData
		public void clkOnBaseDataModule() {
			baseDataModule.click();
		}
		// Then Click on CS View
		
		public void clkOnScanDataOverView() {
			csViewPage.click();
		}
	    //Enter SO number<SONumber>
		public void setSOcsNumber(String SONumber) {
			soTxtBox.clear();
			soTxtBox.sendKeys(SONumber);
		}
		
	  //  And  Click on Search 
		public void clkOnDetailSearchButton() {
			searchBtn.click();
		}
		
	}
