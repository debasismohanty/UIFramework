Feature: ScanData Upload

  @ScanDataUpload
  Scenario Outline: Upload Scan Dateset files and validate Scan Details
    And  Select <ClientName> from Client drop_ScanIB
    Then Click on Admin Module for ScanIB upload_ScanIB
    Then Click on New File Upload for ScanIB upload_ScanIB
    Then Select the Scan Data File Type for ScanIB upload_ScanIB
    And  Upload the ScanData file for ScanIB upload_ScanIB
    Then Verify success message <ValidationMessage> for ScanIB upload_ScanIB
    Then Click on Upload File List available on the side bar for ScanIB upload verification_ScanIB
    And  Select ScanData from File Type drop down for ScanIB upload verification_ScanIB
    And  Enter File Name <FileName> for ScanIB upload verification_ScanIB
    Then Click on Search for ScanIB upload verification_ScanIB
    And  Verify the status <Status> of the uploaded ScanData file <FileName> for ScanIB upload verification_ScanIB
    Then Click on BaseData for ScanIB upload verification_ScanIB
    Then Click on ScanData Overview for ScanIB upload verification_ScanIB
    And  Enter SO number<SONumber> for ScanIB upload verification_ScanIB
    And  Click on Search for ScanIB upload verification_ScanIB_ScanIB
    Then Verify the ScanData Overview details in Result grid <SONumber> for ScanIB upload verification_ScanIB

    Examples: 
    |ValidationMessage                                            |SONumber    |FileName                       |Status     |
    |"L_I_JCPNY_SCNIB.389857614.xml File is uploaded successfully"|"SSS7495765"|"L_I_JCPNY_SCNIB.389857614.xml"|"Completed"|
