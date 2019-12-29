package basic2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetIncidentSysID {


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
		
		String contentType = response.getContentType();
		System.out.println(contentType);
		
		JsonPath responseContent = response.jsonPath();
		
		//responseContent.prettyPrint();

		
		List<String> IncidentNumbers = responseContent.getList("result.number");
		
		System.err.println(IncidentNumbers.size());
		
		for (String eachIncident : IncidentNumbers) {
			System.out.println(eachIncident);
		}
		

		List<String> Incidentsysid= responseContent.getList("result.sys_id");
		
		System.err.println(Incidentsysid.size());
		
		for (String eachsysid : Incidentsysid) {
			System.out.println(eachsysid);
		}	
	}

}
