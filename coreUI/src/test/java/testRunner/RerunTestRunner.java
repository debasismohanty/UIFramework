package testRunner;

import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;
import com.testautomation.Listeners.ExtentReporterListener;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;




//@RunWith(Cucumber.class)
//@Test


@CucumberOptions
	(
		features= {"D:\\ESSPL_Selenium_Projects\\coreUI\\Features\\POUpload.feature"},///CustomerOperation.feature"
		glue= {"stepDefinations"},//,//It will inform on which packages steps are implimented
		//dryRun=false,
		plugin={
				"html:RerunReports/html-report",
				"json:RerunReports/cucumber.json",
				"pretty:RerunReports/cucumber-pretty.txt",
				"usage:RerunReports/cucumber-usage.json",
				"junit:RerunReports/cucumber-results.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:D:\\automationAtEsspl\\coreUI\\RerunReports\\extent-report\\extentreport.html",
				"rerun:target/rerun.txt"
				}
	//	monochrome = true
	//	tags= {"@sanity"}// {"@sanity , @regression"}
		
	)


public class RerunTestRunner extends AbstractTestNGCucumberTests  {  
	
}
