package com.novaemu.sessions;

import org.jboss.netty.channel.Channel;

import com.novaemu.habbo.players.Player;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.utils.ServerMessage;

public class Session {

	private Channel channel;
	private Player player;
	
	public Session(Channel channel) {
		this.channel = channel;
	}
	
	public void send(ServerMessage msg) {
		this.getChannel().write(msg);
	}
	
	public Channel getChannel() {
		return this.channel;
	}

	public void sendAlert(String string) {
		ServerMessage alert = new ServerMessage(Outgoing.HabboBroadcastMessageComposer);
		alert.AppendString(string);
		
		this.send(alert);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}