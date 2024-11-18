package com.sample.crud.withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
/**
 * @author chandan
 * this class helps to Delete the data from ninzaHRM Database
 */
public class SampleTestForDeleteTest {
/**
 * this method helps to Delete the data
 */
	@Test
	public void getDataFromServer()
	{
		delete("http://49.249.28.218:8091/project/NH_PROJ_3517")
	
		.then().statusCode(204)
		
		.log().all();
	}
}
