package com.pk.atf.actor;

public class Actor {
	private String actor;
	private String actorDescription;
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActorDescription() {
		return actorDescription;
	}
	public void setActorDescription(String actorDescription) {
		this.actorDescription = actorDescription;
	}
	@Override
	public String toString() {
		return "Actor [actor=" + actor + ", actorDescription=" + actorDescription + "]";
	}
}
