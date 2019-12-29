package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateChangerequestusingDataProvider {
	
	@DataProvider(name = "fetchfiles")
	public String[] getFiles() {
		
		String[] files = new String[2];
		files[0]="./data1.json";
		files[1]="./data2.json";
		return files;
		
	}
	
	
	
	@Test(dataProvider = "fetchfiles")
	public void createChange(String fileName) {
		
		RestAssured.baseURI ="https://dev87538.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Vishwa@123");
		//File body  = new File("./data1.json");
		File body  = new File(fileName);

		
		Response response = RestAssured
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(body)
				.post();
		
		System.out.println(response.contentType());
		
		JsonPath content = response.jsonPath();
		
		String Num = content.get("result.number");
		
		System.out.println(Num);
	}

}
