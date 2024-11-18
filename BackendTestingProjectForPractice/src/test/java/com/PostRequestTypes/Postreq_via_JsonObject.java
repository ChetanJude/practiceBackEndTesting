package com.PostRequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Postreq_via_JsonObject {
	
	@Test
	public void postDataToServer() {
	JSONObject jsonobj = new JSONObject();
	jsonobj.put("createdBy", "chandan");
	jsonobj.put("projectName", "uniqueoo6");
	jsonobj.put("status", "Created");
	jsonobj.put("teamSize", 0);
	
	given()
	.contentType(ContentType.JSON)
	.body(jsonobj)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.statusCode(201)
	.log().all();
}
}
