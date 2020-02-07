package pageObjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ScanDataOBUpload {
		public WebDriver ldriver;
		
		public ScanDataOBUpload(WebDriver rdriver) {
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
		
		@FindBy(id="rbtnScanFile")
		@CacheLookup
		public WebElement rbttnScanDataOB;
		
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
		
		@FindBy(id="sd7")
		@CacheLookup
		public WebElement scanDataOverviewPage;
		
		@FindBy(id="txtSO")
		@CacheLookup
		public WebElement sdOBTxtBox;
		
		@FindBy(id="btnDetailView")
		@CacheLookup
		public WebElement detailSearchBtn;
		
		@FindBy(id="gvDetailView_lblSO_0")
		@CacheLookup
		public WebElement scanDataResult;
		
		@FindBy(id="btnGroupView")
		@CacheLookup
		public WebElement sdOBGresult;
		
		@FindBy(id="gvGroupView_lblSO_0")
		@CacheLookup
		public WebElement ftchsdOBRwData;
		
		
		//Click on Admin Module	
				public void clkOnAdminModule() {
					adminModule.click();
				}
				
				//Click on New File Upload
				public void clkOnButtonUpld() {
					butttnUpload.click();
				}
		//Click on Upload File List available on the side bar
				public void clkOnUpldFileList() {
					optUpldFileList.click();
				}
				// Then Select the Scan Data File Type <FileName>
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
				//Click on ScanData Overview
				
				public void clkOnScanDataOverView() {
					scanDataOverviewPage.click();
				}
			    //Enter SO number<SONumber>
				public void setsdOBSONumber(String soNumber) {
					sdOBTxtBox.clear();
					sdOBTxtBox.sendKeys(soNumber);
				}
				
			  //  And  Click on Search 
				public void clkOnDetailSearchButton() {
					detailSearchBtn.click();
				}
	}
