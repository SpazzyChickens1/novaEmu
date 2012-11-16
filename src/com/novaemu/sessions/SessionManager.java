package com.novaemu.sessions;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.jboss.netty.channel.Channel;

public class SessionManager {

	private ConcurrentMap<Integer, Session> Sessions;
	
	public SessionManager() {
		
		this.setSessions(new ConcurrentHashMap<Integer, Session>());
	}

	public boolean addSession(Channel channel) {
		
		Session clientSession = new Session(channel);
		
		if(this.getSessions().put(channel.getId(), clientSession) != null) {
			
			channel.setAttachment(clientSession);
			
			return true;
		}
		
		return false;
	}
	
	public void removeSession(Channel channel) {
		this.getSessions().remove(channel.getId());
	}
	
	public ConcurrentMap<Integer, Session> getSessions() {
		return Sessions;
	}

	public void setSessions(ConcurrentMap<Integer, Session> sessions) {
		Sessions = sessions;
	}
	
}
