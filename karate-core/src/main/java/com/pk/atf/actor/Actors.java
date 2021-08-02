package com.pk.atf.actor;

import java.util.List;

public class Actors {
	
	private List<Actor> actors;

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Actors [actors=" + actors + "]";
	}
}

