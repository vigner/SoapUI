package basic2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateChangerequest extends BaseClass{
	
	@Test
	public void createChange() {
		
		File body  = new File("./data1.json");
		Response response = logs.contentType(ContentType.JSON).body(body).post();
		
		System.out.println(response.contentType());
		
		JsonPath content = response.jsonPath();
		
		 Sysid = content.get("result.sys_id");
		
		System.out.println(Sysid);
	}

}
