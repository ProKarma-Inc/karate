package com.pk.atf.actor;

import com.fasterxml.jackson.databind.JsonNode;

public class ActorAuthInfo {
	
	private String actor;
	private JsonNode authStrategies;
	
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public JsonNode getAuthStrategies() {
		return authStrategies;
	}
	public void setAuthStrategies(JsonNode authStrategies) {
		this.authStrategies = authStrategies;
	}
	@Override
	public String toString() {
		return "ActorAuthInfo [actor=" + actor + ", authStrategies=" + authStrategies + "]";
	}
}

