package basicAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PreemptiveAuth {

	@Test
	public void sampleTest()
	{
		given()
		.auth().preemptive().basic("rmgyantra","rmgy@9999")
		.log().all()
		.when()
		.get("http://49.249.29.5:8091/login")
		.then()
		.log().all();
	}
}
