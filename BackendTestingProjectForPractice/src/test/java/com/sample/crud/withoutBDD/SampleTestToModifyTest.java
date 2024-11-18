package com.sample.crud.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
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
		jsonobj.put("createdBy", "chandan");
		//jsonobj.put("projectName", "rich");
		//jsonobj.put("status", "Created");
		//jsonobj.put("teamSize", 0);
		
		//providing pre conditons
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonobj.toJSONString());
		
		Response resp = req.put("http://49.249.28.218:8091/project/NH_PROJ_3492");
		
		//verifying the response
		resp.then().statusCode(200);
		resp.then().log().all();
	}
}

