package com.requestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmpPojo;
import pojoclass.utility.ProjectPojo;

public class Scenario_02_AddEmpToProject {
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
	
	//capture projectName from the Response
	String projName = resp.jsonPath().get("projectName");
	System.out.println(projName);
	
	EmpPojo empobj = new EmpPojo("Architect", "16/10/1998", "chn@gmail.com", "gopi"+random, 18, 
			"9741584340", projName, "ROLE_EMPLOYEE", "gopi"+random);
	given()
	.contentType(ContentType.JSON)
	.body(empobj)
	.when()
	.post("http://49.249.28.218:8091/employees")
	.then()
	.statusCode(201)
	.log().all();
}
}
