package basicAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
public class auth2_0_Authentication {

	@Test
	public void sampleTest()
	{
		Response resp = given()a
		.formParam("client_id","ninza-client")
		.formParam("client_secret","gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type","client_credentials")
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then()
		.contentType(ContentType.JSON)
		.log().all();
		//capture the token from Response
		String token = resp.jsonPath().get("access_token");
				
		given()
		.auth().oauth2(token)
		.log().all()
		.get("http://49.249.28.218:8091/projects")
		.then()
		.log().all();
	
	}
}
