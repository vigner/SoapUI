package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateChangerequest {
	
	@Test
	public void createChange() {
		
		RestAssured.baseURI ="https://dev87538.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Vishwa@123");
		File body  = new File("./data1.json");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(body)
				.post();
		
		System.out.println(response.contentType());
		
		JsonPath content = response.jsonPath();
		
		String Num = content.get("result.number");
		
		System.out.println(Num);
	}

}
