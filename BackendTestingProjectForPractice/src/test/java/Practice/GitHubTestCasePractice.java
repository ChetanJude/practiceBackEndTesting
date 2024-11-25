package Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.backendTesting.Excelutility.Excelutility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.GitHubProjectPojo;
//import techpy.gym.generic.fileUtility.ExcelUtility;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class GitHubTestCasePractice {

	Excelutility elib = new Excelutility();

	@Test(dataProvider = "getData")
	public void createRepo(String repoName ,String description ) throws Throwable
	{
		//API-01 ==> add a repo to git 
		Random r = new Random();
		int random = r.nextInt(5000);
		String repo = repoName+random;
		GitHubProjectPojo ghpp = new GitHubProjectPojo(repo, description);
		String token = elib.getDataFromExcelFile("GitHubData", 1, 4);
		Response resp = given()
		.auth().oauth2(token)
		.contentType(ContentType.JSON)
		.body(ghpp)
		.when()
		.post("https://api.github.com/user/repos");
		resp.then()
		
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.both(Matchers.greaterThan(300L)).and(Matchers.lessThan(5000L)))
		.body("name", Matchers.equalTo(repo))
		.log().all();
		int repoid = resp.jsonPath().get("id");
		System.out.println(repoid);
		
		//capture repoName from the Response
		String reponame = resp.jsonPath().get("name");
		System.out.println(reponame);
		System.out.println("***********************API-01 end***************************");
		
		//API-02 ==> get repo through reponame from git
		String ownerName = elib.getDataFromExcelFile("GitHubData", 1, 2);
		Response resp02 = given()
		
		.get("https://api.github.com/repos/"+ownerName+"/"+reponame);
		resp02.then()
		
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.both(Matchers.greaterThan(300L)).and(Matchers.lessThan(5000L)))
		.body("id", Matchers.equalTo(repoid))
		.log().all();
		System.out.println("***********************API-02 end***************************");
		
		//API-03 ==> update repo through description in git
		String UpdatedDescription = elib.getDataFromExcelFile("GitHubData", 1, 3);
		
		GitHubProjectPojo ghppD = new GitHubProjectPojo(reponame, UpdatedDescription);
		 given()
		.auth().oauth2(token)
		.contentType(ContentType.JSON)
		.body(ghppD)
		.when()
		.patch("https://api.github.com/repos/"+ownerName+"/"+reponame)
		.then()
//		.statusCode(200)
//		.contentType(ContentType.JSON)
//		.time(Matchers.both(Matchers.greaterThan(300L)).and(Matchers.lessThan(5000L)))
		//.body("id", Matchers.equalTo(repoid))
		.log().all();
		System.out.println("***********************API-03 end***************************");
		
		//API-04 ==> delete repo through reponame from git
		Response re = given()
		.auth().oauth2(token)
		.delete("https://api.github.com/repos/"+ownerName+"/"+reponame);
		re.then()
		
		.statusCode(204)
		.time(Matchers.both(Matchers.greaterThan(300L)).and(Matchers.lessThan(5000L)))
		.log().all();
		System.out.println("***********************API-04 end***************************");
		}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		int count = elib.getRowCount("GitHubData");
		Object[][] obarr = new Object[count][2];
		
		for (int i = 0; i < count; i++) {
			
		obarr[i][0] = elib.getDataFromExcelFile("GitHubData",i+1,0);
		obarr[i][1] = elib.getDataFromExcelFile("GitHubData",i+1,1);
		}
		return obarr;	
	}
}
