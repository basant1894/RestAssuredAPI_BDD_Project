package serializationDeserialization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class APITestWithoutSerialization {
	
	public HashMap map=new HashMap();
	
	//Post request creates a new student record
	@Test(priority=1)
	public void createNewRecord(){
		
		map.put("id", "101");
		map.put("firstName", "Basant");
		map.put("lastName", "Chaudhary");
		map.put("email", "basu123@gmail.com");
		map.put("programme", "Manager");
		
		ArrayList<String> courcesList=new ArrayList<String>();
		courcesList.add("Java");
		courcesList.add("Selenium");
		
		map.put("cources", courcesList);
		
		given()
		   .contentType(ContentType.JSON)
		   .body(map)
		.when()
		   .post("http://localhost:8085/student")
		.then()
		   .statusCode(201)
		   .assertThat()
		   .body("msg",equalTo("Student added"));
		
		//Get Request to retrieve student details
	}
		@Test(priority=2)
		public void getStudentRecord(){
			given()
			   
			.when()
			   .post("http://localhost:8085/student/101")
			.then()
			   .statusCode(201)
			   .assertThat()
			   .body("id",equalTo("101"));
			
		}
		
	}
	


