package com.pk.atf.actor;

import com.fasterxml.jackson.databind.JsonNode;
import com.intuit.karate.http.HttpClient;
import com.intuit.karate.http.HttpRequestBuilder;

public class APIKeyAuthenticaton implements Authenticator {

	@Override
	public void authenticate(HttpRequestBuilder requestBuilder, JsonNode authInfo, HttpClient client) {

		String apikeyName = authInfo.get("apikeyName").asText();
		String apikeyValue = authInfo.get("apikeyValue").asText();
		String apikeyAddedTo = authInfo.get("apikeyAddedTo").asText();

		switch (apikeyAddedTo) {
		case "HEADER":
			requestBuilder.header(apikeyName, apikeyValue);
			break;
		case "COOKIE":
			requestBuilder.cookie(apikeyName, apikeyValue);
			break;
		case "REQUEST":
			String urlAndPath = requestBuilder.getUrlAndPath();
			String append = urlAndPath.indexOf('?') == -1 ? "?" : "&";
			urlAndPath = urlAndPath + append + apikeyName+"="+apikeyValue;
			requestBuilder.url(urlAndPath);
			break;
		default:
			break;
		}
	}

}
