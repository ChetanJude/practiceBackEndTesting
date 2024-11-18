package ddt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.utility.ProjectPojo;
import techpy.gym.generic.fileUtility.ExcelUtility;

import static io.restassured.RestAssured.*;

public class Ddt_Using_DataProvider {

	@Test(dataProvider = "getData")
	public void sampleTest(String projectName,String status)
	{
		ProjectPojo ppo = new ProjectPojo(projectName,"chandan",status,0);
		given()
		.contentType(ContentType.JSON)
		.body(ppo)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility elib = new ExcelUtility();
		int count = elib.getRowCount("Data");
		Object[][] objarr = new Object[count][2];

		for (int i = 0; i < count; i++) {

			objarr[i][0] = elib.getDataFromExcelFile("Data", i+1, 0);
			objarr[i][1] = elib.getDataFromExcelFile("Data", i+1, 1);
		}
		return objarr;
	}
}

