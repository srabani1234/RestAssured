package com.api.pages;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.is;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class createIssueInJira {
	
	String sessionID ;
	RequestSpecification Request_Speci;
	Response response ;
	String responseBody ;
	// JESessionID of cookies
	
	public void sessionAPIUpAndRunning(String userName, String passWord) {
		JSONObject js = new JSONObject();
		js.put("username",userName);
		js.put("password",passWord);
		Request_Speci =
				 given()
			.baseUri("http://localhost:8086/rest/auth/1").header("content-type", "application/json").body(js);
	}
	
	public void hitSessionAPIURL(String qp) {
		response= Request_Speci.when().post(qp).then().log().all().extract().response();
		sessionID = response.getCookies().get("JSESSIONID");
		System.out.println(response.getCookies().get("JSESSIONID"));
	}
		
	
	public void createIssueAPIUpAndRunning() {

		Request_Speci =
				 given()
			.baseUri("http://localhost:8086/rest/api/2").header("content-type", "application/json")
			.cookie("JSESSIONID",sessionID);
	}
	
	public void passPayLoadToCreateIssueAPI(Object payLoad) {
		Request_Speci= Request_Speci.body(payLoad);
	}
	
	public void hitCreateIssueURL(String qp) {
		response= Request_Speci.when().post(qp);
	}
	
	public String verifyIssueCreated() {
	String responseBody = response.then().log().all().extract().response().asString();
		return responseBody;
	
	}
	public int createIssueAPIStatusCode() {
		int statusCode=	response.getStatusCode();
		return statusCode;
	}
		// http://localhost:8086/projects/RA/issues/RA-3?filter=allopenissues
	public String getGeneratedID() {
		
		JsonPath jsonpath = response.jsonPath();
		String id = jsonpath.get("id");
	
		System.out.println(id);
		
		return id;
	
	}
	
	public String getGeneratedSelf() {
		JsonPath jsonpath = response.jsonPath();
		
		String self = jsonpath.get("self");
		
		System.out.println(self);
		return self;
	
	}
	


}
