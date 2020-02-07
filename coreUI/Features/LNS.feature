Feature: LNS Application Automation

  @POUpload
  Scenario Outline: Upload PO files and validate PO Details
    Given Select <ClientName> from Client drop
    Then Click on Admin Module
    Then Click on New File Upload
    And Upload the file <Fpath>
    Then Verify success message <ValidationMessage>
    Then Click on Upload File List available on the side bar
    And Select <FileType> from File Type drop down
    And Enter File Name <FileName>
    Then Click on Search
    And Verify the status <Status> of the uploaded file <FileName>
    Then Click on BaseData
    And Search for the Number <Number>
    Then Verify the PO Details in the Result grid <Number>

    Examples: 
      | ClientName  | Fpath                                                                   | ValidationMessage                                                | FileType | Number      | FileName                           | Status      |
      | "JC Penney" | "E:\\Automation\\coreUI\\FileUploads\\L_O_LNS_PO.A877CB7D.A015A041.xml" | "L_O_LNS_PO.A877CB7D.A015A041.xml File is uploaded successfully" | "PO"     | "SS7513355" | "L_O_LNS_PO.A877CB7D.A015A041.xml" | "Completed.." |

   @SOUpload
  Scenario Outline: Upload SO files and validate SO Details
    Given Select <ClientName> from Client drop
    Then Click on Admin Module
    Then Click on New File Upload
    Then Select the SO File Type_SO
    And Upload the file <Fpath>
    Then Verify success message <ValidationMessage>
    Then Click on Upload File List available on the side bar
    And Select <FileType> from File Type drop down
    And Enter File Name <FileName>
    Then Click on Search
    And Verify the status <Status> of the uploaded file <FileName>
    Then Click on BaseData
    Then Click on SO View for SO Upload verification_SO
    And Search for the SO Number <Number>
    Then Verify the SO Details in the Result grid <Number>

    Examples: 
      | ClientName  | Fpath                                                                   | ValidationMessage                                                | Number       | FileType | FileName                           | Status      |
      | "JC Penney" | "E:\\Automation\\coreUI\\FileUploads\\L_O_LNS_SO.AE6383EB.A7416243.xml" | "L_O_LNS_SO.AE6383EB.A7416243.xml File is uploaded successfully" | "SSS7495765" | "SO"     | "L_O_LNS_SO.AE6383EB.A7416243.xml" | "Completed" |

  @LPUpload
  Scenario Outline: Upload LP files and validate LP Details
    Given Select <ClientName> from Client drop
    Then Click on Admin Module
    Then Click on New File Upload
    Then Select the LP File Type_LP
    And Upload the file <Fpath>
    Then Verify success message <ValidationMessage>
    Then Click on Upload File List available on the side bar
    And Select <FileType> from File Type drop down
    And Enter File Name <FileName>
    Then Click on Search
    And Verify the status <Status> of the uploaded file <FileName>
    Then Click on BaseData
    Then Click on LP View for LP Upload verification_LP
    Then Search the PO <Number> for LP Upload verification_LP
    Then Verify the LP Details in the Result grid <Number>

    Examples: 
      | ClientName  | Fpath                                                                             | ValidationMessage                                                          | Number      | FileType | FileName                                     | Status      |
      | "JC Penney" | "E:\\Automation\\coreUI\\FileUploads\\LI_LNSJCPN_LP.17083114197C34.381070233.xml" | "LI_LNSJCPN_LP.17083114197C34.381070233.xml File is uploaded successfully" | "SS7513355" | "LP"     | "LI_LNSJCPN_LP.17083114197C34.381070233.xml" | "Completed" |

  @ScanDataUpload
  Scenario Outline: Upload Scan Dateset files and validate Scan Details
    Given Select <ClientName> from Client drop
    Then Click on Admin Module
    Then Click on New File Upload
    Then Select the Scan data File Type_ScanIB
    And Upload the file <Fpath>
    Then Verify success message <ValidationMessage>
    Then Click on Upload File List available on the side bar
    And Select <FileType> from File Type drop down
    And Enter File Name <FileName>
    Then Click on Search
    And Verify the status <Status> of the uploaded file <FileName>
    Then Click on BaseData
    Then Click on ScanData Overview for ScanIB Upload verification_ScanIB
    And Search the SO <Number> for ScanIB Upload verification_ScanIB
    Then Verify the ScanData Overview Details in the Result grid <Number>

    Examples: 
      | ClientName  | Fpath                                                                   | ValidationMessage                                             | Number       | FileType   | FileName                        | Status      |
      | "JC Penney" | "E:\\Automation\\coreUI\\FileUploads\\L_O_LNS_PO.A877CB7D.A015A041.xml" | "L_I_JCPNY_SCNIB.389857614.xml File is uploaded successfully" | "SSS7495765" | "ScanData" | "L_I_JCPNY_SCNIB.389857614.xml" | "Completed" |

  @ScanDataUpload
  Scenario Outline: Upload Scan Dateset files and validate Scan Details
    Given Select <ClientName> from Client drop
    Then Click on Admin Module
    Then Click on New File Upload
    Then Select the Scan data File Type_ScanOB
    And Upload the file <Fpath>
    Then Verify success message <ValidationMessage>
    Then Click on Upload File List available on the side bar
    And Select <FileType> from File Type drop down
    And Enter File Name <FileName>
    Then Click on Search
    And Verify the status <Status> of the uploaded file <FileName>
    Then Click on BaseData
    Then Click on ScanData Overview for ScanOB Upload verification_ScanOB
    And Search the SO <Number> for ScanOB Upload verification_ScanOB
    Then Verify the ScanData Overview Details in the Result grid <Number>

    Examples: 
      | ClientName  | Fpath                                                               | ValidationMessage                                            | Number       | FileType   | FileName                       | Status      |
      | "JC Penney" | "E:\\Automation\\coreUI\\FileUploads\\L_I_JCPNY_SCAN.389857614.xml" | "L_I_JCPNY_SCAN.389857614.xml File is uploaded successfully" | "SSS7495765" | "ScanData" | "L_I_JCPNY_SCAN.389857614.xml" | "Completed" |

  @CSUpload
   Scenario Outline: Upload CS files and validate CS Details
    Given Select <ClientName> from Client drop
    Then Click on Admin Module
    Then Click on New File Upload
    Then Select the CS File Type_CS
    And Upload the file <Fpath>
    Then Verify success message <ValidationMessage>
    Then Click on Upload File List available on the side bar
    And Select <FileType> from File Type drop down
    And Enter File Name <FileName>
    Then Click on Search
    And Verify the status <Status> of the uploaded file <FileName>
    Then Click on BaseData
    Then Click on CS View for CS Upload verification_CS
    And Search the SO <SONumber> for CS Upload verification_CS
    Then Verify the SO Number against the CS Number in Result grid <SONumber><CSNumber> for CS upload verification

    Examples: 
      | ClientName  | Fpath                                                                          | ValidationMessage                                                       | CSNumber     | SONumber     | FileType    | FileName                                  | Status      |
      | "JC Penney" | "E:\\Automation\\coreUI\\FileUploads\\LO_LNS_CSR.17092106373WUE.389863588.xml" | "LO_LNS_CSR.17092106373WUE.389863588.xml File is uploaded successfully" | "JHT9506515" | "SSS7495765" | "CSRequest" | "LO_LNS_CSR.17092106373WUE.389863588.xml" | "Completed" |

       