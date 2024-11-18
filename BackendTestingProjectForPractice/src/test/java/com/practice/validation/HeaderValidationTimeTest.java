package com.practice.validation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class HeaderValidationTimeTest {

	@Test
	public void verifyHeader()
	{
		Response resp = given()
				.get("http://49.249.28.218:8091/projects");
		resp.then().log().all();
		long timeTaken = resp.time();
		long timeTakenSec = resp.timeIn(TimeUnit.SECONDS);
		System.out.println(timeTaken);
		System.out.println(timeTakenSec);
		resp.then().time(Matchers.greaterThan(300L));
		resp.then().time(Matchers.lessThan(4000L));
		resp.then().time(Matchers.both(Matchers.greaterThan(2000L)).and(Matchers.lessThan(4000L)));
}
}