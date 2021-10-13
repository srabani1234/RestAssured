package com.stepDefination;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.pages.createIssueInJira;
import com.pojo.issue.Fields;
import com.pojo.issue.Payload;
import com.pojo.issue.Project;
import com.pojo.issue.issueType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class createJiraIssuePageTest {
	createIssueInJira issue = new createIssueInJira();
	issueType iss = new issueType("Task");
	Project pro = new Project("RA");
	Payload pay = new Payload("Demo","Demo tasy",iss,pro);
	Fields fields = new Fields(pay);
	
	@Given("Create Session API is up and running with username as {string} & password as {string}")
	public void create_Session_API_is_up_and_running_with_username_as_password_as(String userName, String passWord) {
		issue.sessionAPIUpAndRunning(userName, passWord);
	}

	@Given("hit Create Session API url with base path as {string}")
	public void hit_Create_Session_API_url_with_base_path_as(String hitURL) {
	   issue.hitSessionAPIURL(hitURL);
	}

	@When("Create Issue API is up and running")
	public void create_Issue_API_is_up_and_running() {
	  issue.createIssueAPIUpAndRunning();
	}

	@When("hit Create Issue API url with base path as {string}")
	public void hit_Create_Issue_API_url_with_base_path_as(String hitURL) {
	 issue.hitCreateIssueURL(hitURL);
	}

	@When("I pass Payload details to create issue")
	public void i_pass_Payload_details_to_create_issue() {
	   issue.passPayLoadToCreateIssueAPI(fields);
	}
	@Then("New issue will be created with url {string}")
	public void new_issue_will_be_created(String url) {
	 String responseBody =  issue.verifyIssueCreated();
     System.out.println(responseBody);
     String id =issue.getGeneratedID();
     String self = issue.getGeneratedSelf();
     Assert.assertEquals(self, url+id);
	}
    @Then("API returns the response with status code display as {int}")
    public void api_returns_the_response_with_status_code_display_as(int status) {
    	int sta= issue.createIssueAPIStatusCode();
    	Assert.assertEquals(sta, status);
    }



}
