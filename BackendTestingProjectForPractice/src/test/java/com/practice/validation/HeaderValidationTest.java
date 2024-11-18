package com.practice.validation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class HeaderValidationTest {

	@Test
	public void verifyHeader()
	{
		Response resp = given()
				.get("http://49.249.28.218:8091/projects");
		resp.then().log().all();
		resp.then().statusCode(200);
		resp.then().contentType(ContentType.JSON);
		resp.then().header("Keep-Alive", "timeout=70");
}
}