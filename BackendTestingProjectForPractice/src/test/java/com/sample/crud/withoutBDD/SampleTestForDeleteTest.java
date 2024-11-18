package com.sample.crud.withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
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
		Response resp = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_3648");
	
		resp.then().statusCode(204);
		
		resp.then().log().all();
	}
}
