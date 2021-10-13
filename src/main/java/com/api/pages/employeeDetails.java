package com.api.pages;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.is;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class employeeDetails {
	RequestSpecification Request_Speci;
	Response response ;
	String responseBody ;
	
	public void employeeAPIUpAndRunning() {
		
		Request_Speci =
				 given()
			.baseUri("http://dummy.restapiexample.com/api/v1/employee");
	}
	
	public void hitEmployeeURL(String qp) {
		response= Request_Speci.when().get(qp);
	}
	
	public String verifyResponseBody() {
		String responseBody = response.then().log().all().extract().response().asString();
		
		System.out.println(responseBody);
		return responseBody;
	//	org.junit.Assert.assertEquals(responseBody.contains("Successfully! Record has been deleted"), true);
		
	}
	public int verifyStatusCode() {
	int statusCode=	response.getStatusCode();
	return statusCode;
		
	}

}
