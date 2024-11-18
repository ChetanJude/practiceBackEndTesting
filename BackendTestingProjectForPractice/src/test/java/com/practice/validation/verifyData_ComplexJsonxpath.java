package com.practice.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.List;

public class verifyData_ComplexJsonxpath {

	@Test
	public void verifyHeader()
	{
		Response resp = given()
				.get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		
	List<String> list = JsonPath.read(resp.asString(),".content[*].projectId");
	for(String data:list)
	{
	System.out.println(data);
	}
	
	List<String> list01 = JsonPath.read(resp.asString(),".content[*].[?(@.projectName=='Apple100')].projectId");
	String actProjectId = list01.get(0);
	
	Assert.assertEquals(actProjectId, "NH_PROJ_979");
}
}