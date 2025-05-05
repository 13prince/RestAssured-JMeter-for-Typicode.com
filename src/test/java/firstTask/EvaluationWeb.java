package firstTask;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import io.opentelemetry.api.trace.StatusCode;

public class EvaluationWeb {
	@Test
	public void getPosts() {
		given().get("https://jsonplaceholder.typicode.com/posts/1").then().statusCode(200).log().all();
	}
	
	@Test
	public void postPosts() {
		JSONObject js2 = new JSONObject();
		   js2.put("title", "foo");
		   js2.put("body", "bar");
		   js2.put("userid", 1);
		   given()
		   .contentType(ContentType.JSON).body(js2.toJSONString()).when().post("https://jsonplaceholder.typicode.com/posts")
		   .then().statusCode(201).log().all();
		   
	}
	
	@Test
	public void putPosts() {
		JSONObject js3 = new JSONObject();
		   js3.put("title", "Prince");
		   js3.put("body", "Musculiar");
		   js3.put("userid", 1);
		   given()
		   .contentType(ContentType.JSON).body(js3.toJSONString()).when().put("https://jsonplaceholder.typicode.com/posts/1")
		   .then().statusCode(200).log().all();
		   
	}
	
	@Test
	public void patchPosts() {
		JSONObject js4 = new JSONObject();
		   js4.put("title", "Updated Title Sarswat");
		   given()
		   .contentType(ContentType.JSON).body(js4.toJSONString()).when().patch("https://jsonplaceholder.typicode.com/posts/1")
		   .then().statusCode(200).log().all();
		   
	}
	
	@Test
	public void deletePosts() {
			   
		   given().delete("https://jsonplaceholder.typicode.com/posts/1")
		   .then().statusCode(200).log().all();
		   
	}
	
	
}
