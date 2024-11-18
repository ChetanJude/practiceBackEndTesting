package encryption;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import javax.crypto.NoSuchPaddingException;

public class UpdatePayrollinfoViaAESEncryption {

	@Test
	public void sampleTest() throws Exception
	{
		EncryptAndDecryptUtility eadu = new EncryptAndDecryptUtility();
		
		String jbody = "{ \"employee\": { \"empId\":\"NH_00725\", \"designation\": \"string\","
				+ " \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\","
				+ " \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\","
				+ " \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0,"
				+ " \"hra\": 566754, \"insurance\": 0, \"lta\": 4567, \"lwf\": 0, \"netPay\": 5000, "
				+ "\"payroll_id\": 707, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Disabled” }";
		
		String jreqbody = eadu.encrypt(jbody, "Ac03tEam@j!tu_#1");
		System.out.println(jreqbody);
		
		Response resp = given()
		.body(jreqbody)
		.when()
		.put("http://49.249.28.218:8091/payroll");
		resp.then().log().all();
		String respbody = eadu.decreypt(resp.getBody().asString(), "Ac03tEam@j!tu_#1");
		System.out.println(respbody);
		
		
}
}
