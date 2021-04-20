package com.qa.test;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.GETCLientByID;

public class GETUserByIDTest extends TestBase
{

	TestBase tb;
	String baseUrl;
	String serviceURL_ID;
	String completeURL;
	CloseableHttpResponse response;

	@BeforeTest
	public void setUp() {
		tb = new TestBase();
		baseUrl = prop.getProperty("URL");
		serviceURL_ID = prop.getProperty("serviceURL_ID");
		completeURL = baseUrl + serviceURL_ID;
	}

	@Test
	public void getTest() throws Exception, IOException {
		GETCLientByID getRequest = new GETCLientByID();
		response = getRequest.getUserByID(completeURL);

		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Status code is----->"+statusCode);
		Assert.assertEquals(statusCode, RESPONSE_CODE_STATUS_200,"The reponse code is not 200");
		//		if(equals(200)) {
		//		System.out.println("The Status code of GET User By ID API is Correct");
		//		}
		//		
		//		else {
		//			System.out.println("The Status code of GET User By ID API is not Correct");
		//		}
	}


}
