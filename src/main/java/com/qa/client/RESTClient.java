package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RESTClient {

	//GET method
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url); //http get request
		CloseableHttpResponse response = httpClient.execute(httpGet); //hit the get URL

		//get status code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("The Status Code is ------> "+statusCode);

		//get reponse as a string
		String totalResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(totalResponse);

		//To convert the complete message to JSON format
		JSONObject responseJSON = new JSONObject(totalResponse);
		System.out.println("The response from GET API is ------>"+responseJSON);

		Header[] headerArray = response.getAllHeaders();

		HashMap<String, String> allheaders = new HashMap<String, String>();
		for(Header header : headerArray) {
			allheaders.put(header.getName(), header.getValue());
		}
		
		System.out.println("The headers are ------>"+allheaders);
	}
}
