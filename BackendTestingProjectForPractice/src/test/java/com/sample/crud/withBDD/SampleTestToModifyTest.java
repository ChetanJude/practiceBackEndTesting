package com.sample.crud.withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * @author chandan
 * this class helps to Modify the data from ninzaHRM Database
 */
public class SampleTestToModifyTest {
/**
 * this method helps to Modify the data
 */
	@Test
	public void putDataToServer()
	{
		//providing payload/body
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "chandan01");
		//jsonobj.put("projectName", "rich");
		//jsonobj.put("status", "Created");
		//jsonobj.put("teamSize", 0);
		
		//providing pre conditons
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj.toJSONString())
		
		.put("http://49.249.28.218:8091/project/NH_PROJ_3517")
		
		//verifying the response
		.then().statusCode(200)
		.log().all();
	}
}

