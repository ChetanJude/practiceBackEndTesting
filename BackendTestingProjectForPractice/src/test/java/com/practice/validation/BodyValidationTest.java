package com.practice.validation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BodyValidationTest {

	@Test
	public void verifyHeader()
	{
		Response resp = given()
				.get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		resp.then().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().body("pageable.sort.empty", Matchers.equalTo(true));
		resp.then().body("content[0].projectId", Matchers.equalTo("NH_PROJ_979"));
		
}
}