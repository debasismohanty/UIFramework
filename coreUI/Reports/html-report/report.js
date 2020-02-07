$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/LNS.feature");
formatter.feature({
  "line": 1,
  "name": "LNS Application Automation",
  "description": "",
  "id": "lns-application-automation",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Upload PO files and validate PO Details",
  "description": "",
  "id": "lns-application-automation;upload-po-files-and-validate-po-details",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@POUpload"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Select \u003cClientName\u003e from Client drop",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Click on Admin Module",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Click on New File Upload",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Upload the file \u003cFpath\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Verify success message \u003cValidationMessage\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Click on Upload File List available on the side bar",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Select \u003cFileType\u003e from File Type drop down",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Enter File Name \u003cFileName\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Click on Search",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Verify the status \u003cStatus\u003e of the uploaded file \u003cFileName\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Click on BaseData",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Search for the Number \u003cNumber\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Verify the PO Details in the Result grid \u003cNumber\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "lns-application-automation;upload-po-files-and-validate-po-details;",
  "rows": [
    {
      "cells": [
        "ClientName",
        "Fpath",
        "ValidationMessage",
        "FileType",
        "Number",
        "FileName",
        "Status"
      ],
      "line": 20,
      "id": "lns-application-automation;upload-po-files-and-validate-po-details;;1"
    },
    {
      "cells": [
        "\"JC Penney\"",
        "\"E:\\Automation\\coreUI\\FileUploads\\L_O_LNS_PO.A877CB7D.A015A041.xml\"",
        "\"L_O_LNS_PO.A877CB7D.A015A041.xml File is uploaded successfully\"",
        "\"PO\"",
        "\"SS7513355\"",
        "\"L_O_LNS_PO.A877CB7D.A015A041.xml\"",
        "\"Completed..\""
      ],
      "line": 21,
      "id": "lns-application-automation;upload-po-files-and-validate-po-details;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 13560181700,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Upload PO files and validate PO Details",
  "description": "",
  "id": "lns-application-automation;upload-po-files-and-validate-po-details;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@POUpload"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Select \"JC Penney\" from Client drop",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Click on Admin Module",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Click on New File Upload",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Upload the file \"E:\\Automation\\coreUI\\FileUploads\\L_O_LNS_PO.A877CB7D.A015A041.xml\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Verify success message \"L_O_LNS_PO.A877CB7D.A015A041.xml File is uploaded successfully\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Click on Upload File List available on the side bar",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Select \"PO\" from File Type drop down",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Enter File Name \"L_O_LNS_PO.A877CB7D.A015A041.xml\"",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Click on Search",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Verify the status \"Completed..\" of the uploaded file \"L_O_LNS_PO.A877CB7D.A015A041.xml\"",
  "matchedColumns": [
    5,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Click on BaseData",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Search for the Number \"SS7513355\"",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Verify the PO Details in the Result grid \"SS7513355\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "JC Penney",
      "offset": 8
    }
  ],
  "location": "Steps.select_from_Client_drop(String)"
});
formatter.result({
  "duration": 7152785600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Admin_Module()"
});
formatter.result({
  "duration": 7324737100,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_New_File_Upload()"
});
formatter.result({
  "duration": 12454116700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "E:\\Automation\\coreUI\\FileUploads\\L_O_LNS_PO.A877CB7D.A015A041.xml",
      "offset": 17
    }
  ],
  "location": "Steps.upload_the_file(String)"
});
formatter.result({
  "duration": 6943995600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "L_O_LNS_PO.A877CB7D.A015A041.xml File is uploaded successfully",
      "offset": 24
    }
  ],
  "location": "Steps.verify_success_message(String)"
});
formatter.result({
  "duration": 4086370900,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Upload_File_List_available_on_the_side_bar()"
});
formatter.result({
  "duration": 7373775300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "PO",
      "offset": 8
    }
  ],
  "location": "Steps.select_from_File_Type_drop_down(String)"
});
formatter.result({
  "duration": 10406425900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "L_O_LNS_PO.A877CB7D.A015A041.xml",
      "offset": 17
    }
  ],
  "location": "Steps.enter_File_Name(String)"
});
formatter.result({
  "duration": 5030949000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Search()"
});
formatter.result({
  "duration": 5371487800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Completed..",
      "offset": 19
    },
    {
      "val": "L_O_LNS_PO.A877CB7D.A015A041.xml",
      "offset": 54
    }
  ],
  "location": "Steps.verify_the_status_of_the_uploaded_file(String,String)"
});
formatter.result({
  "duration": 15857927000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_BaseData()"
});
formatter.result({
  "duration": 5433043100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SS7513355",
      "offset": 23
    }
  ],
  "location": "Steps.search_for_the_Number(String)"
});
formatter.result({
  "duration": 12637903200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SS7513355",
      "offset": 42
    }
  ],
  "location": "Steps.verify_the_PO_Details_in_the_Result_grid(String)"
});
formatter.result({
  "duration": 16723840300,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.write("Scenario Passed..");
formatter.after({
  "duration": 1109482000,
  "status": "passed"
});
});