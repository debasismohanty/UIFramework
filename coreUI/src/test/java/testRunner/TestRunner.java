package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;


@CucumberOptions
	(
		features= {".//Features/LNS.feature"},    //{".//Features/POUpload.feature",".//Features/SOUpload.feature",".//Features/LPUpload.feature"}, //{".//Features/Login.feature",".//Features/CustomerOperation.feature"}, // // 
		glue= {"stepDefinations"},//,//It will inform on which packages steps are implemented
		tags= {"@POUpload"},
		plugin={"html:Reports/html-report",
				"json:Reports/cucumber.json",
				"pretty:Reports/cucumber-pretty.txt",
				"usage:Reports/cucumber-usage.json",
				"junit:Reports/cucumber-results.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:E:\\Automation\\coreUI\\Reports\\extent-report\\extentreport.html",
				"rerun:target/rerun.txt"}
	
	//	tags= {"@sanity"}// {"@sanity , @regression"}
		
	)
//monochrome = true
//test
public class TestRunner extends AbstractTestNGCucumberTests  {  
	
	
}



/*

@ExtendedCucumberOptions(jsonReport="target/cucumber.json"
,retryCount = 3
,detailedReport = true
,detailedAggregatedReport = true
,overviewReport = true
,coverageReport = true
,jsonUsageReport = "target/cucumber-usage.json"
,usageReport = true
,toPDF = true
//,excludeCoverageTags = {}
,includeCoverageTags = {"@chrome"}
,outputFolder = "Target")

*/
