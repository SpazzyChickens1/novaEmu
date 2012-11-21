package com.novaemu.protocol.navigator;

import com.novaemu.habbo.rooms.Room;
import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class MyRoomsSearchMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		ServerMessage Response = new ServerMessage(Outgoing.GuestRoomSearchResultComposer);

		Response.AppendInt32(0);
		Response.AppendInt32(6);
		Response.AppendStringWithBreak("");
		
		Response.AppendInt32(Client.getPlayer().getHabbo().Rooms.size());
		
		for(Room room : Client.getPlayer().getHabbo().Rooms) {
			
			Response.AppendInt32(room.Id);
			
			Response.AppendBoolean(false);
			
			Response.AppendStringWithBreak(room.Name);
			Response.AppendStringWithBreak(room.Owner);
			
			Response.AppendInt32(0);
			Response.AppendInt32(room.Clients.size());
			Response.AppendInt32(100);
			
			Response.AppendStringWithBreak(room.Description);
			
			Response.AppendInt32(0);
			
			Response.AppendBoolean(true);
			
			Response.AppendInt32(room.Rating);
			Response.AppendInt32(room.Category);
			
			Response.AppendStringWithBreak("");
			
			Response.AppendInt32(room.Tags.length); // tag count
			
			for(String tag : room.Tags) {
				Response.AppendStringWithBreak(tag);			
			}
			
			Response.AppendInt32(0); // icon bg
			Response.AppendInt32(0); // icon overlay
			Response.AppendInt32(0); // icon fg overlay
			
			Response.AppendInt32(0);
			Response.AppendInt32(1);
		}
		
		Client.send(Response);
		
	}

}
