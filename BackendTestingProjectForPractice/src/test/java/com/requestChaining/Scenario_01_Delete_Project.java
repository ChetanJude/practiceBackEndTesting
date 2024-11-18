package com.requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.ProjectPojo;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Scenario_01_Delete_Project {
	
	@Test
	public void postDataToServer() {
		
		//create an object to pojo class
		Random r= new Random();
		int random = r.nextInt(5000);
		
		//api-01 ==> add a project in side server
		ProjectPojo ppo = new ProjectPojo("unique"+random,"chandan","Created",0);
	Response resp=given()
			.contentType(ContentType.JSON)
			.body(ppo)
			.when()
			.post("http://49.249.28.218:8091/addProject");
	resp.then()
		.statusCode(201)
		.log().all();
	
	//capture projectId from the Response
	String projectId = resp.jsonPath().get("projectId");
	System.out.println(projectId);
	
	//api-02 ==> delete a project
	given()
		.delete("http://49.249.28.218:8091/project/"+projectId)
		.then().log().all();
}
}
