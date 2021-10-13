package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"..\\RestAssuredAPI\\src\\main\\java\\com\\api\\feature\\createIssueJira.feature"},
		glue="com\\stepDefination",
	//	tags="@t1",
		dryRun=false,
		strict=true,
		monochrome=true,
		plugin= {"pretty", "junit:target/cucumber-reports/Cucumber.xml",
		"rerun:target/rerurnScenarios.txt"}
		
		)
public class createIssueRunner {

}
