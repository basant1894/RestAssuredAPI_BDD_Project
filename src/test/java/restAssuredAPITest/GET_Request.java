package restAssuredAPITest;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GET_Request {
	
@Test	
public void getWeatherDetails(){
	
	given()
	.when()
	    .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
	.then()
	    .statusCode(200)
	    .statusLine("HTTP/1.1 200 OK")
	    .assertThat().body("City", equalTo("Hyderabad"))
	    .header("Content-Type", "application/json");	

}

private ResponseAwareMatcher<Response> equalTo(String string) {
	return null;	
  }
}
