package Practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestUsingMethodChaining {

	@Test
	public void sampleGetReqTest()
	{
		get("https://reqres.in/api/users?page=2").then().log().all();
		
	}
}
