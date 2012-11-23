package com.novaemu.sessions;

import org.jboss.netty.channel.Channel;

import com.novaemu.habbo.players.Player;
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
	
	public void Disconnect() {
		this.getPlayer().onDisconnect();
		this.getChannel().disconnect();
	}
	
	public Channel getChannel() {
		return this.channel;
	}

	
	public void sendAlert(String string) {
		ServerMessage alert = new ServerMessage(808);
		alert.AppendStringWithBreak("Message from Hotel Management");
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