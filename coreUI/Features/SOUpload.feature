Feature: SO Upload

  @SOUpload
	Scenario Outline: Upload SO files and validate SO Details  
		Given Select <ClientName> from Client drop
    Then Click on Admin Module
    Then Click on New File Upload for SO Upload_SO
    Then Select the SO File Type_SO
    And  Upload the <SO> file_SO
    Then Verify success message <ValidationMessage> for SO Upload_SO
    Then Click on Upload File List available on the side bar for SO Upload_SO
    Then  Select SO from File Type drop down_SO
    Then  Enter File Name <FileName> for SO Upload verification_SO
    Then Click on Search for SO Upload verification_SO
    Then  Verify the status <Status> of the uploaded SO file<FileName>_SO
    Then Click on BaseData for SO Upload verification_SO
    Then Click on SO View for SO Upload verification_SO
    Then  Search for the SO <SONumber> for SO Upload verification_SO
    Then Verify the SO details in the Result grid <SONumber> for SO Upload verification_SO

    Examples: 
     | ClientName  |ValidationMessage                                                |Number    |FileName                          |Status     |
     | "JC Penney" |"L_O_LNS_SO.AE6383EB.A7416243.xml File is uploaded successfully" |"SSS7495765"|"L_O_LNS_SO.AE6383EB.A7416243.xml"|"Completed"|
      
