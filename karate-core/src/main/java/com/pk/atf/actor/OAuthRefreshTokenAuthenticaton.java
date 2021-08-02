package com.pk.atf.actor;

import com.fasterxml.jackson.databind.JsonNode;
import com.intuit.karate.Json;
import com.intuit.karate.http.HttpClient;
import com.intuit.karate.http.HttpRequestBuilder;
import com.intuit.karate.http.Response;

public class OAuthRefreshTokenAuthenticaton implements Authenticator {

	@Override
	public void authenticate(HttpRequestBuilder requestBuilder, JsonNode authInfo, HttpClient client) {

		String tokenURL = authInfo.get("tokenURL").asText();
		String clientId = authInfo.get("clientId").asText();
		String clientSecret = authInfo.get("clientSecret").asText();
		String refreshToken = authInfo.get("refreshToken").asText();

		String requestBody="grant_type=refresh_token&client_id="+clientId+"&client_secret="+clientSecret+"&refresh_token="+refreshToken;


		HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder(client);
		httpRequestBuilder.contentType("application/x-www-form-urlencoded");

		httpRequestBuilder.url(tokenURL);
		httpRequestBuilder.method("POST");
		httpRequestBuilder.body(requestBody);

		Response response = httpRequestBuilder.invoke();

		if(response.getStatus()==200) {
			Json json = response.json();
			String accessToken = json.get("access_token",String.class);
			requestBuilder.header("Authorization", "Bearer "+accessToken);
		}
		else {
			throw new RuntimeException("Failed to get the access token " + response.getBodyAsString());
		}
	}
}
