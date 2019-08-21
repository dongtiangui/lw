package com.lw.model;

import java.io.Serializable;


public class SessionModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5836813473943643510L;

	private String sessionId;
	
	private String session;
	
	private String user;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
