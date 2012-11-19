package com.novaemu.sessions;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.jboss.netty.channel.Channel;

public class SessionManager {

	private ConcurrentMap<Integer, Session> Sessions;
	
	public SessionManager() {
		
		this.setSessions(new ConcurrentHashMap<Integer, Session>());
	}

	public boolean addSession(final Channel channel) {

		try {
			final Session clientSession = new Session(channel);

			this.getSessions().put(channel.getId(), clientSession);

			channel.setAttachment(clientSession);

			return true;
		} catch (final Exception e) {
			return false;
		}
	}
	
	public Session getClientByHabbo(int Id) {
		for(Session client : this.getSessions().values()) {
			
			if(client.getPlayer() != null) {
				if(client.getPlayer().getHabbo().Id == Id) {
					return client;
				}
			}
			
		}
		return null;
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
