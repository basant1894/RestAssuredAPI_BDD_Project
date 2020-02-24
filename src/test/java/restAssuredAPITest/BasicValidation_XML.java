package restAssuredAPITest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;


/*
 * 
 1)Verifying Single content in XML Response
 2)Verifying Multiple content in XML Response
 3)Verifying all the content in XML Response in one go
 4)XPath with text() function
 5)Find values using XML Path in XML response
 
 * 
 */

public class BasicValidation_XML {
	
	//1)Verifying Single content in XML Response
	@Test(priority=1)
	void testSingleContent(){
		
		given()
		
		.when()
		   .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		   .body("CUSTOMER.ID", equalTo("15"))
		   .log().all();
	}
	//2)Verifying Multiple content in XML Response
	@Test(priority=2)
	void testMultipleContent(){
	given()
	
	.when()
	   .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
	
	.then()
	   .body("CUSTOMER.ID", equalTo("15"))
	   .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
	   .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
	   .body("CUSTOMER.STREET", equalTo("319 Upland pl."))
	   .body("CUSTOMER.CITY", equalTo("Seattle"));
	   
	
}
	//3)Verifying all the content in XML Response in one go
	//4)XPath with text() function
	@Test(priority=3)
	void testMultipleContentInOneGo(){
	given()
	
	.when()
	   .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
	
	.then()
	   .body("CUSTOMER.text()", equalTo("15BillClancy319 Upland pl.Seattle"));
	   
}
	 //5)Find values using XML Path in XML response
	@Test(priority=4)
	void testUsingXPath1(){
		given()
		
		.when()
		   .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		   
		.then();
		  // .body(hasXPath("/CUSTOMER/FIRSTNAME", contains("Bill")));
	
	}
	@Test(priority=5)
	void testUsingXPath2(){
		given()
		
		.when()
		   .get("http://thomas-bayer.com/sqlrest/INVOICE/")
		   
        .then()
           .body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
		   .log().all();
}
}
