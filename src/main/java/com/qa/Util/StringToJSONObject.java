package com.qa.Util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class StringToJSONObject {
	
	static CloseableHttpResponse responseInString;
	static StringToJSONObject responseJSON;
	
	public StringToJSONObject(CloseableHttpResponse response) {
		this.responseInString = response;
	}
	
	public StringToJSONObject convertResponseToJSONObject(String response) {
		
		//To convert response in the String Format
		responseInString = EntityUtils.toString(response.getEntity(), "UTF-8");
		
		//To Convert response from String format to JSON Object
		responseJSON = new StringToJSONObject(responseInString);
		
		return responseJSON;
		
	}

}
