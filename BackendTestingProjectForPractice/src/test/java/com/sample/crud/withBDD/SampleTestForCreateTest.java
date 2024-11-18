package com.sample.crud.withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
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
		jsonobj.put("projectName", "unique09");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
		
		//providing pre conditons
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj.toJSONString())
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		//verifying the response
		.then().statusCode(201)
		.log().all();
	}
}
