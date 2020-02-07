Feature: LP Upload
		
		@LPUpload
    Scenario Outline: Upload LP files and validate LP Details
    And  Select <ClientName> from Client drop_LP
    Then Click on Admin Module for LP Upload_LP
    Then Click on new File Upload for LP Upload_LP
    Then Select the LP File as file Type for LP Upload_LP
    And  Upload the LP file for LP Upload_LP
    Then Verify success message <ValidationMessage> for LP Upload_LP
    Then Click on upload File List available on the side bar for LP Upload_LP
    And  Select LP from File Type drop down for LP Upload verification_LP
    And  Enter File Name <FileName> for LP Upload verification_LP
    Then Click on search for LP Upload verification_LP
    And  Verify the status <Status> of the file name <FileName>_LP 
    Then Click on BaseData for LP Upload verification_LP
    Then Click on LP View for LP Upload verification_LP
    And  Search the PO <PONumber> for LP Upload verification_LP
    Then Verify the PO Details in Result grid <PONumber> for LP Upload verification_LP
   
    Examples:
    |ValidationMessage								                                         |PONumber	 |FileName	                                  |Status     |
    |"LI_LNSJCPN_LP.17083114197C34.381070233.xml File is uploaded successfully"|"SS7513355"|"LI_LNSJCPN_LP.17083114197C34.381070233.xml"|"Completed"|