package Practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Example {

	@Test
	public void sampleTest()
	{
		Response resp1 = given()
				.contentType(ContentType.JSON)
				.when()
				.get("https://airportgap.com/api/airports");

		resp1.then()
		.log().all();
		String id = resp1.jsonPath().get("data[-].id");
		System.out.println(id);

		Response resp = given()
				.formParam("email", "test@airportgap.com")
				.formParam("password", "airportgappassword")
				.when()
				.post("https://airportgap.com/api/tokens");
		resp.then()
		.log().all();
		String token = resp.jsonPath().get("token");

		Response resp2 = given()

				.auth().oauth2(token)
				.formParam("airport_id", id)
				.when()
				.post("https://airportgap.com/api/favorites");

		resp2.then()
		.log().all();
		
		
		
		
		
		
		
		
		
		
		String id2 = resp2.jsonPath().get("data.id");
		Response resp3 = given()

				.auth().oauth2(token)
				.when()
				.delete("https://airportgap.com/api/favorites/"+id2);
		resp3.then()
		.log().all();

	}
}
