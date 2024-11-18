package com.PostRequestTypes;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Postreq_via_HashMap {
	
	@Test
	public void postDataToServer() {
	HashMap<String, Object> hM = new HashMap();
	hM.put("createdBy", "chandan");
	hM.put("projectName", "uniqueoo2");
	hM.put("status", "Created");
	hM.put("teamSize", 0);
	given()
	.contentType(ContentType.JSON)
	.body(hM)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.statusCode(201)
	.log().all();
}
}
