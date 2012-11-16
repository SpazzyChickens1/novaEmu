package com.novaemu.sessions;

import org.jboss.netty.channel.Channel;

import com.novaemu.utils.ServerMessage;

public class Session {

	private Channel channel;

	public Session(Channel channel) {
		this.channel = channel;
	}
	
	public void send(ServerMessage msg) {
		this.getChannel().write(msg);
	}
	
	public Channel getChannel() {
		return this.channel;
	}
}