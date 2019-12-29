package basic2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateChangerequest extends BaseClass{

	@Test(dependsOnMethods =  "basic2.CreateChangerequest.createChange")
	public void UpdateChangerequest() {
		
		File body  = new File("./data1.json");
		Response response = logs.contentType(ContentType.JSON).body(body).put(Sysid);
		
		System.out.println(response.contentType());
		
		JsonPath content = response.jsonPath();
		
		 Sysid = content.get("result.sys_id");
		
		System.out.println(Sysid);
	}

}
