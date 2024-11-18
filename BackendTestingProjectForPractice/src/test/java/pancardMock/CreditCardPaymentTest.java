package pancardMock;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.http.ContentType;

public class CreditCardPaymentTest {

	@Test
	public void paymentTest()
	{	
		JSONObject job = new JSONObject();
		job.put("creditcard", "1234567891234");
		job.put("cvv", "123");
		job.put("cardName", "chandan");
		given()
		//.contentType(ContentType.JSON)
		.body(job)
		.when()
		.post("http://localhost:8889/credit-card")
		.then().log().all();
	}
}
