Feature: ScanData Upload

  @ScanDataUpload
  Scenario Outline: Upload Scan Dateset files and validate Scan Details
    And  Select <ClientName> from Client drop_ScanOB
    Then Click on Admin Module for ScanOB upload_ScanOB
    Then Click on New File Upload ScanOB upload_ScanOB
    Then Select the Scan Data File Type ScanOB upload_ScanOB
    And  Upload the ScanData file ScanOB upload_ScanOB
    Then Verify success message <ValidationMessage> ScanOB upload_ScanOB
    Then Click on Upload File List available on the side bar for ScanOB upload verification_ScanOB
    And  Select ScanData from File Type drop down for ScanOB upload verification_ScanOB
    And  Enter File Name <FileName> for ScanOB upload verification_ScanOB
    Then Click on Search for ScanOB upload verification_ScanOB
    And  Verify the status <Status> of the uploaded ScanData file <FileName> for ScanOB upload verification_ScanOB
    Then Click on BaseData for ScanOB upload verification_ScanOB
    Then Click on ScanData Overview for ScanOB upload verification_ScanOB
    And  Search for the SO <SONumber> for ScanOB upload verification_ScanOB
    Then Verify the ScanData Overview details in Result grid <SONumber> for ScanOB upload verification_ScanOB

    Examples: 
    |ValidationMessage                                           |SONumber     |FileName								      |Status	    |
    |"L_I_JCPNY_SCAN.389857614.xml File is uploaded successfully"|"SSS7495765" |"L_I_JCPNY_SCAN.389857614.xml"|"Completed"|
