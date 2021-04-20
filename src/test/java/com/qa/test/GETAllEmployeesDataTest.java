package com.qa.test;

import java.io.IOException;
import com.qa.Util.JSONParser;
import com.qa.Util.StringToJSONObject;
import com.qa.base.TestBase;
import com.qa.client.RESTClient;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class GETAllEmployeesDataTest extends TestBase {
	
	TestBase tb;
	String GETAPIURL;
	CloseableHttpResponse response;
	JSONObject responseJson;
	String expectedStatus = "success";
	
	//To Setup GET URL
	@BeforeTest
	public void setUpGETAllEmployeesDataAPI() {
		tb = new TestBase();
		GETAPIURL = (prop.getProperty("EMPLOYEEURL")+(prop.getProperty("getallEmployeeURI")));
		
	}
	
	//To test the reponse of GET API WebService
	@Test
	public void GETAllEmployeesData() throws ClientProtocolException, IOException {
		System.out.println(GETAPIURL);
		
		RESTClient getRequest = new RESTClient();
		response = getRequest.get(GETAPIURL);
		
		System.out.println(response);
	}
	
	//Test to validate the status code
	@Test
	public void statusCodeTest() {
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("The Status Code is ------> "+statusCode);
	}
	
	//To test the "Status" JSON Object from the response
	@Test
	public void responseStatusTest() throws Exception, Exception {
		
		System.out.println("Test Case to validate the status Object is Executing........");
		
		//To convert the response from webservice to String format
		String responseInString = EntityUtils.toString(response.getEntity(), "UTF-8");
		
		//To convert complete response to JSON Object
		responseJson = new JSONObject(responseInString);
		//StringToJSONObject jo = new StringToJSONObject(response);
		System.out.println("The reponse from the webservice in JSON Format is ------->" + responseJson);
		
		//To Parse the JSON response and Validate the value of Message Object
		String statusValue = JSONParser.getValueByJPath(responseJson, "/status");
		System.out.println("The value of Message object is ------->"+statusValue);
		if(statusValue.contentEquals(expectedStatus)) {
			System.out.println("The Value of Message value from the response is as EXPECTED");
		}
		
		else {
			System.out.println("The Value of Message value from the response is NOT as EXPECTED");
		}
		
	}
	
	public void responseMessageTest() {
		responseJson = new JSONObject();
	}

}
