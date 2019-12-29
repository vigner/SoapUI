package basic2;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public static String Sysid;
	
	public static RequestSpecification logs;
	@BeforeSuite
	public void launch() {
		
		
		RestAssured.baseURI ="https://dev87538.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Vishwa@123");
		
		logs =  RestAssured.given().log().all();
	}

}
