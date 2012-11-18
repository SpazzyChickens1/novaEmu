package com.novaemu.protocol.handshake;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.novaemu.novaEmu;
import com.novaemu.habbo.players.Habbo;
import com.novaemu.habbo.players.Player;
import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class SSOTicketMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		try {
			
			String ticket = novaEmu.filter(msg.popFixedString());
			ServerMessage Response;
			
			if(!novaEmu.getServer().getStorage().entryExists("SELECT id FROM users WHERE auth_ticket = '" + ticket + "'")) {
				Client.sendAlert("User was not found");
				return;
			}
			
			ResultSet User = novaEmu.getServer().getStorage().readRow("SELECT * FROM users WHERE auth_ticket = '" + ticket + "'");
			
			Habbo habbo = new Habbo(
					User.getInt("id"),
					User.getString("username"),
					User.getString("gender"),
					User.getString("look"),
					User.getString("motto"),
					User.getInt("credits")
					);
			
			Player player = new Player(habbo);
			Client.setPlayer(player);

			Response = new ServerMessage(Outgoing.InfoFeedEnableMessageComposer);
			Response.AppendBoolean(true);
			Client.send(Response);
			
			Response = new ServerMessage(Outgoing.AuthenticationOKMessageComposer);
			Client.send(Response);
			
			
			Client.sendAlert("Hey, " + Client.getPlayer().getHabbo().Username);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
