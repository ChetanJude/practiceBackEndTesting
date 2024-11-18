package com.PostRequestTypes;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import pojoclass.utility.ProjectPojo;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Random;

public class Postreq_via_PojoClass {
	
	@Test
	public void postDataToServer() {
		
		Random r= new Random();
		int random = r.nextInt(5000);
		ProjectPojo ppo = new ProjectPojo("unique"+random,"chandan","Created",0);
	 given()
	.contentType(ContentType.JSON)
	.body(ppo)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.statusCode(201)
	.log().all()
	.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/main/resources/jsonschema.json")));
}
}
