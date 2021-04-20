package com.qa.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RESTClient;

public class GetAPItest extends TestBase{
	
	TestBase testbase;
	String url;
	String apiURL;
	String mainURL;
	
	@BeforeMethod
	public void setUp(){
		testbase = new TestBase();
		url = prop.getProperty("URL");
		apiURL = prop.getProperty("serviceURL");
		mainURL = url + apiURL;
			
	}
	
	@Test
	public void getTest() throws Exception, IOException {
		RESTClient getRequest = new RESTClient();
		getRequest.get(mainURL);
	}

	public void isBarking() {
		
	}
	
}
