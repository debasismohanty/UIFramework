package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

/**
 * 
 * @author debasismohanty
 *
 */
@CucumberOptions
	(
		features= {".//Features/LNS.feature"}, 
		glue= {"stepDefinations"},//,//It will inform on which packages steps are implemented
		//tags= {"@POUpload"},
		plugin={"html:Reports/html-report",
				//"json:Reports/cucumber.json",
				//"pretty:Reports/cucumber-pretty.txt",
				//"usage:Reports/cucumber-usage.json",
				//"junit:Reports/cucumber-results.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:E:\\Automation\\coreUI\\Reports\\extent-report\\extentreport.html",
				"rerun:target/rerun.txt"
				
		}
		
	)

public class TestRunner extends AbstractTestNGCucumberTests  {  
	
	
}

