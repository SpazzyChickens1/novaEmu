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
				Client.Disconnect();
				return;
			}
			
			ResultSet User = novaEmu.getServer().getStorage().readRow("SELECT * FROM users WHERE auth_ticket = '" + ticket + "'");
			
			Habbo habbo = new Habbo(
					Client,
					User.getInt("id"),
					User.getString("username"),
					User.getString("gender"),
					User.getString("look"),
					User.getString("motto"),
					User.getInt("credits"),
					User.getInt("activity_points")
					);
			
			Player player = new Player(habbo);
			Client.setPlayer(player);

			Client.getPlayer().getHabbo().getMessenger().loadBuddies();
			
			Response = new ServerMessage(Outgoing.InfoFeedEnableMessageComposer);
			Response.AppendBoolean(true);
			Client.send(Response);
			
			Response = new ServerMessage(Outgoing.AuthenticationOKMessageComposer);
			Client.send(Response);
			
			if(Integer.parseInt(novaEmu.getServer().config.getProperty("hotel.welcome_message.enabled")) == 1) {
				
				String alert = novaEmu.getServer().config.getProperty("hotel.welcome_message");
				String alert2 = alert.replace("{username}", Client.getPlayer().getHabbo().Username);
				
				Client.sendAlert(alert2);

			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
