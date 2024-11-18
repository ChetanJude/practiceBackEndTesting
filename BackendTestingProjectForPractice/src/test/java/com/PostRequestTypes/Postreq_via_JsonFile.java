package com.PostRequestTypes;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class Postreq_via_JsonFile {
	
	@Test
	public void postDataToServer() {
		
		File fobj = new File("./HRM.json");
	given()
	.contentType(ContentType.JSON)
	.body(fobj)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.statusCode(201)
	.log().all();
}
}
