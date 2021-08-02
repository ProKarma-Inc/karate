package com.pk.atf.actor;

import java.util.List;

public class AuthenticationInfo {
	
	private List<ActorAuthInfo> actorAuthInfo;

	public List<ActorAuthInfo> getActorAuthInfo() {
		return actorAuthInfo;
	}
	public void setActorAuthInfo(List<ActorAuthInfo> actorAuthInfo) {
		this.actorAuthInfo = actorAuthInfo;
	}

	@Override
	public String toString() {
		return "AuthenticationInfo [actorAuthInfo=" + actorAuthInfo + "]";
	}
}