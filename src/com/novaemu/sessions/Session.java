package com.novaemu.sessions;

import org.jboss.netty.channel.Channel;

public class Session {

	private Channel channel;

	public Session(Channel channel) {
		this.channel = channel;
	}
	
	public Channel getChannel() {
		return this.channel;
	}
}