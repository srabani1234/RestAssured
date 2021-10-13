package com.stepDefination;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.pages.employeeDetails;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class employeDetailsPageTest {
	employeeDetails empDetails = new employeeDetails() ;
	
	@Given("^Employee Details API is up and running$")
	public void employee_Details_API_is_up_and_running() throws Throwable {
		empDetails.employeeAPIUpAndRunning();
	}

	@When("^hit url with quary parameter as \"([^\"]*)\"$")
	public void hit_url_with_quary_parameter_as(String qp) throws Throwable {
		empDetails.hitEmployeeURL(qp);
	}
@Test
    @Then("API returns the response with status code as {int}")
    public void api_returns_the_response_with_status_code_as(int status) {
    	int sta= empDetails.verifyStatusCode();
    	Assert.assertEquals(sta, status);
    }

	@Then("^all the Employee details will be return for employee \"([^\"]*)\"$")
	public void all_the_Employee_details_will_be_return(String empName) throws Throwable {
		String resBody = empDetails.verifyResponseBody();
		Assert.assertTrue(resBody!=null);
		Assert.assertEquals(resBody.contains(empName),true);
	}


}
