package restAssuredAPITest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * 
 1)Test Status Code
 2)Log Response
 3)Verifying Single content in response body
 4)Verifying Multiple content in response body
 5)Setting parameters & headers
 *
 */
public class BasicValidation_JSON {
	
	//1)Test Status Code
	@Test(priority=1)
	public void testStatusCode(){
		
		given()
		
		.when()
		   .get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
		   .statusCode(200)
		   .log().all();
		 
		
	}
	//2)Log Response
	@Test(priority=2)
	public void testLogging(){
		
		given()
		
		.when()
		   .get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
		   .statusCode(200)
		   .log().all();
	}
	//3)Verifying Single content in response body
	@Test(priority=3)
	public void testSingleContent(){
		
        given()
		
		.when()
		   .get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
		   .statusCode(200)
		   .body("RestResponse.result.name", equalTo("India"));
	}
	//4)Verifying Multiple content in response body
		@Test(priority=4)
		public void testMultipleContent(){
			
	        given()
			
			.when()
			   .get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
			   .statusCode(200)
			   .body("RestResponse.result.name", equalTo("India"));
	           //.body("RestResponse.result.name",hasItem("India","Australia,"United Statesof America"));
		}
		//5)Setting parameters & headers
		@Test(priority=5)
		public void testParametersAndHeaders(){
			
	        given()
	           .param("MyName","Basant")
	           .header("Jharkhand","India")
			
			.when()
			   .get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
			   .statusCode(200)
			   .log().all();
		
}}
