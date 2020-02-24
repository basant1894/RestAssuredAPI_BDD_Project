package restAssuredAPITest;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

/*import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.parsing.Parser;
import io.restassured.specification.Argument;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;*/

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POST_Request {
	
	public static HashMap map= new HashMap();
	
	@BeforeClass
	public void postdata(){
		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";
		
	}
	@Test
	public void testPost(){
		given()
		    .contentType("application/json") 
		    .body(map)
		
		.when()
		    .post()
		
		.then()
		    .statusCode(201)
		    /*.and()
		    .body("SuccessCode", equalTo("OPERATION_SUCCESS"))
		    .and()
		    .body("Message", equalTo("Operation completed successfully"))*/;
	}

}
