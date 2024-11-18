package com.sample.crud.withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

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
		given().get("http://49.249.28.218:8091/NH_PROJ_3517")
	
		.then().statusCode(200)
		
		.log().all();
	}
}
