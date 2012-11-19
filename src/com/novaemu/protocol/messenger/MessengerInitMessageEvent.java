package com.novaemu.protocol.messenger;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.novaemu.novaEmu;
import com.novaemu.habbo.players.Player;
import com.novaemu.habbo.players.messenger.Friend;
import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class MessengerInitMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		try {
			Player Player = Client.getPlayer();
			
			ServerMessage Response = new ServerMessage(Outgoing.MessengerInitComposer);
	
			Response.AppendInt32(600);
			Response.AppendInt32(200);
			Response.AppendInt32(600);
			Response.AppendInt32(900);
			Response.AppendBoolean(false);
			Response.AppendInt32(Player.getHabbo().getMessenger().getFriends().size());
	        
			for(Friend friend : Player.getHabbo().getMessenger().getFriends().values()) {
				ResultSet User = novaEmu.getServer().getStorage().readRow("SELECT * FROM users WHERE id = " + friend.Id);
				
				Boolean online;
				if(novaEmu.getServer().getSessionManager().getClientByHabbo(friend.Id) != null) {
					online = true;
				} else {
					online = false;
				}
				
				Response.AppendInt32(friend.Id);
				Response.AppendStringWithBreak(User.getString("username"));
				Response.AppendBoolean(false);
	
				Response.AppendBoolean(online);
				Response.AppendBoolean(false);
				Response.AppendStringWithBreak(User.getString("look"));
				Response.AppendBoolean(false);
				Response.AppendStringWithBreak(User.getString("motto"));
			
				Response.AppendStringWithBreak("1-1-2012");
	            Response.AppendStringWithBreak("");
	            Response.AppendStringWithBreak("");
			}
			
			Response.AppendInt32(100);
			Response.AppendInt32(0);
			
			Client.send(Response);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
}
