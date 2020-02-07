Feature: CS Upload

@CSUpload
   Scenario Outline: Upload CS files and validate CS Details
   And  Select <ClientName> from Client drop
   Then Click on Admin Module for CS upload
   Then Click on New File Upload for CS upload
   Then Select the CS File File Type for CS upload
   And  Upload the CS file for CS upload
   Then Verify success message <ValidationMessage> for CS upload
   Then Click on Upload File List available on the side bar for CS upload verification
   And  Select CSRequest from File Type drop down for CS upload verification
   And  Enter File Name <FileName> for CS upload verification
   Then Click on Search for CS upload verification
   And  Verify the status <Status> of the file <FileName> for CS upload verification
   Then Click on BaseData for CS upload verification
   Then Click on CS View for CS upload verification
   And  Search the SO <SONumber> for CS upload verification
   Then Verify the SO Number against the CS Number in Result grid <SONumber><CSNumber> for CS upload verification
   
    Examples:
    |ValidationMessage						                                          |Status			|FileName		                              | SONumber   |CSNumber    |
    |"LO_LNS_CSR.17092106373WUE.389863588.xml File is uploaded successfully"|"Completed"|"LO_LNS_CSR.17092106373WUE.389863588.xml"|"SSS7495765"|"JHT9506515"|