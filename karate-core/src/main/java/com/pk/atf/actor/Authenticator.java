package com.pk.atf.actor;

import com.fasterxml.jackson.databind.JsonNode;
import com.intuit.karate.http.HttpClient;
import com.intuit.karate.http.HttpRequestBuilder;

public interface Authenticator {
	
	public void authenticate(HttpRequestBuilder requestBuilder, JsonNode authInfo, HttpClient client);

}
