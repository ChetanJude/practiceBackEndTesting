package Practice;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;

import  static io.restassured.RestAssured.*;
//import static com.backend.testing.A.*;
public class runner {

//	@Test
//	public void sampleTest() throws Throwable
//	{
//		given()
//		.body("{ getAllProjects{ projectId} }")
//		.when().post("http://49.249.28.218:8091/getAll")
//		.then()
//		.log().all();
		
		public static void main(String[] args) {

			Spark.port(8889);
			Spark.post("/credit-card", (req,res)->{
				String response ="";
				String card = JsonPath.read(req.body().toString(),"$.creditcard");
				if(StringUtils.equalsAny(card,"1234567891234","1234567891235")) {
					response = "{\"status\":\"Payment success\"}";
					res.status(200);
				}else {
					response = "{\"status\":\"Payment failed\"}";
					res.status(404);
				}
				res.type("application/json");
				return response;
			});
			System.out.println("====*************Running*************====");
			
		}
		
	}
