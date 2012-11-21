package com.novaemu.protocol.players;

import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class InfoRetrieveMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
			int Id = Client.getPlayer().getHabbo().Id;
			String Username = Client.getPlayer().getHabbo().Username;
			String Figure = Client.getPlayer().getHabbo().Figure;
			String Motto = Client.getPlayer().getHabbo().Motto;
			String Gender = Client.getPlayer().getHabbo().Gender;
			
			ServerMessage Response = new ServerMessage(Outgoing.UserObjectComposer);
	
			Response.AppendString(Integer.toString(Id));
			Response.AppendStringWithBreak(Username);
			Response.AppendStringWithBreak(Figure);
			Response.AppendStringWithBreak(Gender);
			Response.AppendStringWithBreak(Motto);
			Response.AppendBoolean(false);
			Response.AppendStringWithBreak("");
			Response.AppendBoolean(false);
			Response.AppendBoolean(false);
			Response.AppendBoolean(false);
			Response.AppendBoolean(false);	
			
			Client.send(Response);
	}

}
