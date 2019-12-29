package basic2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetIncidents {


	@Test
	public void getAllIncidents() {

		RestAssured.baseURI ="https://dev87538.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Vishwa@123");
		Response response = RestAssured.get();
		int responseCode = response.getStatusCode();
		
		ResponseBody body = response.getBody();
		System.out.println(body);
		
		String str =response.toString();
		
		System.out.println(str);
		
		
System.err.println(responseCode);

	}

}
