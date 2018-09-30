package Selenium.Utils;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {
	
	
	/**
	 * Get call
	 * @param endpoint 
	 * @param headers  - list of key value pair
	 * @return
	 */
	public String getRestCall(String endpoint, HashMap<String, String> headers){
		RestAssured.baseURI = endpoint;
		RequestSpecification httpRequest = RestAssured.given();
		for(Entry<String,String> header: headers.entrySet()){
			httpRequest.header(header.getKey(),header.getValue());
		}
		Response response = httpRequest.request(Method.GET);
		String responseBody = response.getBody().asString();
		System.out.println("Status code : " + response.getStatusCode());
		System.out.println("Response Body is =>  " + responseBody);
		return responseBody; 
	}
	
	/**
	 * Post call 
	 * 
	 * @param endpoint - url
	 * @param body
	 * @param headers  - list of key value pair
	 * @return
	 */
	public String postRest(String endpoint, String body, HashMap<String, String> headers){
		RestAssured.baseURI = endpoint;
		RequestSpecification httpRequest = RestAssured.given();
		for(Entry<String,String> header: headers.entrySet()){
			httpRequest.header(header.getKey(),header.getValue());
		}
		System.out.println("Request body " +body);
		httpRequest.body(body);
		Response response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		System.out.println("Status code : " + response.getStatusCode());
		System.out.println("Response Body is =>  " + responseBody);
		return responseBody; 
	}
	
	/** Build json request
	 * @param data - list of key value pair
	 * @return
	 */
	public String buildJsonRequest(HashMap<String, String> data) { JSONObject jd = new JSONObject();
		for(Entry<String,String> entry: data.entrySet()){
			jd.put(entry.getKey(),entry.getValue());
		}
		return jd.toString();
		
	}
}


