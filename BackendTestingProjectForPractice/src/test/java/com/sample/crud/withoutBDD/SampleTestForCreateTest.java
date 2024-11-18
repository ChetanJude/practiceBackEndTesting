package com.sample.crud.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * @author chandan
 * this class helps to Create the data in ninzaHRM Database
 */
public class SampleTestForCreateTest {
/**
 * this method helps to Create the data
 */
	@Test
	public void postDataToServer()
	{
		//creating payload/body
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "chandan");
		jsonobj.put("projectName", "unique12345");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
		
		//providing pre conditons
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonobj.toJSONString());
		
		Response resp = req.post("http://49.249.28.218:8091/addProject");
		
		//verifying the response
		resp.then().assertThat().statusCode(201);
		resp.then().log().all();
	}
}
