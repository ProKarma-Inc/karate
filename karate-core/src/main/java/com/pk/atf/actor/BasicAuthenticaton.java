package com.pk.atf.actor;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.fasterxml.jackson.databind.JsonNode;
import com.intuit.karate.http.HttpClient;
import com.intuit.karate.http.HttpRequestBuilder;

public class BasicAuthenticaton implements Authenticator {

	@Override
	public void authenticate(HttpRequestBuilder requestBuilder, JsonNode authInfo, HttpClient client) {
		
		String username = authInfo.get("username").asText();
		String password = authInfo.get("password").asText();
		
		String encodeString = username+":"+password;
		try {
			String base64encodedString = Base64.getEncoder().encodeToString(encodeString.getBytes("utf-8"));
			requestBuilder.header("Authorization", "Basic "+base64encodedString);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
