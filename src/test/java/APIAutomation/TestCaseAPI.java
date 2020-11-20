package APIAutomation;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utils.Utils;


public class TestCaseAPI extends Utils{

	@Test(priority=1)
	public void verifyResponseWithoutKey() throws IOException {
		String baseURL=readProperties("APIUrl");
		String payload="{\r\n" + 
				"  \"external_id\": \"SF_TEST001\",\r\n" + 
				"  \"name\": \"San Francisco Test Station\",\r\n" + 
				"  \"latitude\": 37.76,\r\n" + 
				"  \"longitude\": -122.43,\r\n" + 
				"  \"altitude\": 150\r\n" + 
				"}";

		int statusCode = 
				given()
				.contentType(ContentType.JSON)
				.body(payload)
				.post(baseURL)
				.getStatusCode();

		System.out.println("Status code is:"+statusCode);

		Assert.assertEquals(statusCode, 401);

		String responseBody = 
				given()
				.contentType(ContentType.JSON)
				.body(payload)
				.post(baseURL)
				.getBody()
				.asString();

		System.out.println(responseBody);

		Assert.assertEquals(responseBody, "{\"cod\":401, \"message\": \"Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.\"}");

	}

	@Test(priority=2)
	public void registerStations() throws IOException {
		String baseURL=readProperties("APIUrl");
		String APIKey=readProperties("APIKey");

		String payload1="{\r\n" + 
				"	\"external_id\": \"IQ_TEST001\",\r\n" + 
				"	\"name\": \"Interview Station <Random Number>\", \r\n" + 
				"	\"latitude\": 12.93,\r\n" + 
				"	\"longitude\": 77.68,\r\n" + 
				"	\"altitude\": 920\r\n" + 
				"}\r\n" + 
				"";

		String payload2="{\r\n" + 
				"	\"external_id\": \"IQ_TEST002\",\r\n" + 
				"	\"name\": \"Interview Station <Random Number>\", \r\n" + 
				"	\"latitude\": 40.72,\r\n" + 
				"	\"longitude\": -74.03,\r\n" + 
				"	\"altitude\": 920\r\n" + 
				"}\r\n" + 
				"";

		int responseCode1 = given()
				.contentType(ContentType.JSON)
				.body(payload1)
				.post(baseURL+APIKey).getStatusCode();

		System.out.println("Response Code is:"+responseCode1);
		Assert.assertEquals(responseCode1, 201);

		int responseCode2 = given()
				.contentType(ContentType.JSON)
				.body(payload2)
				.post(baseURL+APIKey).getStatusCode();

		System.out.println("Response Code is:"+responseCode2);
		Assert.assertEquals(responseCode2, 201);
	}

	@Test(priority=3)
	public void getStations() throws IOException {
		String baseURL=readProperties("APIUrl");

		RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON).param("appid", "c609909898d99848b7652d8c50fa2766");
		Response response = httpRequest.get(baseURL);

		JsonPath jsonPathEvaluator = response.jsonPath();

		List<String> id = jsonPathEvaluator.getList("id");

		String station1=id.get(0);
		String station2=id.get(1);

		System.out.println(station1);
		System.out.println(station2);

		int responseCode1=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.get(baseURL+"/"+station1).getStatusCode();

		ResponseBody responseBody1=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.get(baseURL+"/"+station1).getBody();

		Assert.assertEquals(responseBody1.asString().contains("IQ_TEST001"),true,"Station is created successfully");

		System.out.println("Status code is:"+responseCode1);
		Assert.assertEquals(responseCode1, 200);


		int responseCode2=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.get(baseURL+"/"+station2).getStatusCode();

		ResponseBody responseBody2=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.get(baseURL+"/"+station2).getBody();

		Assert.assertEquals(responseBody2.asString().contains("IQ_TEST002"),true,"Station is created successfully");

		System.out.println("Status code is:"+responseCode2);
		Assert.assertEquals(responseCode2, 200);
	}

	@Test(priority=4)
	public void deleteStationsAndVerify() throws IOException, InterruptedException {
		String baseURL=readProperties("APIUrl");
		RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON).param("appid", "c609909898d99848b7652d8c50fa2766");
		Response response = httpRequest.get(baseURL);

		JsonPath jsonPathEvaluator = response.jsonPath();

		List<String> id = jsonPathEvaluator.getList("id");

		final String station1=id.get(0);
		final String station2=id.get(1);

		System.out.println(station1);
		System.out.println(station2);

		int responseCode1=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.delete(baseURL+"/"+station1).getStatusCode();

		System.out.println("RResponse code is:"+responseCode1);
		Assert.assertEquals(responseCode1, 204);

		int responseCode2=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.delete(baseURL+"/"+station2).getStatusCode();

		System.out.println("RResponse code is:"+responseCode1);
		Assert.assertEquals(responseCode2, 204);

		//Verify Stations are deleted
		int responseCode3=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.get(baseURL+"/"+station1).getStatusCode();

		ResponseBody responseBody1=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.get(baseURL+"/"+station1).getBody();

		Assert.assertEquals(responseBody1.asString().contains("Station not found"),true,"Station is deleted successfully");

		System.out.println("Status code is:"+responseCode1);
		Assert.assertEquals(responseCode3, 404);


		int responseCode4=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.get(baseURL+"/"+station2).getStatusCode();

		ResponseBody responseBody2=given()
				.contentType(ContentType.JSON)
				.param("appid", "c609909898d99848b7652d8c50fa2766")
				.get(baseURL+"/"+station2).getBody();

		Assert.assertEquals(responseBody2.asString().contains("Station not found"),true,"Station is deleted successfully");

		System.out.println("Status code is:"+responseCode2);
		Assert.assertEquals(responseCode4, 404);
	}
}
