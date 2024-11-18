package com.sample.crud.withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
/**
 * @author chandan
 * this class helps to read the data from ninzaHRM Database
 */
public class SampleTestForReadTest {
/**
 * this method helps to read the data
 */
	@Test
	public void getDataFromServer()
	{
		Response resp = RestAssured.get("http://49.249.28.218:8091/projects");
	
		resp.then().assertThat().statusCode(200);
		
		resp.then().log().all();
	}
}
