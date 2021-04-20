package com.qa.client;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class GETCLientByID {
	
	public CloseableHttpResponse getUserByID(String url) throws Exception, IOException {
		
		//to create a request
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//to create a get request
		HttpGet get = new HttpGet(url);
		
		//to generate the reponse
		CloseableHttpResponse response = httpClient.execute(get);
		
		return response;
		
		
		
	}

}
