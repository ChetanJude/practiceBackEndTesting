package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest {

	@Test
	public void sampleGetReqTest()
	{
		Response resp = RestAssured.get("http://49.249.28.218:8091/projects");
		resp.prettyPrint();
	}
}
