package com.novaemu.protocol.navigator;

import java.sql.SQLException;
import java.util.List;

import com.novaemu.novaEmu;
import com.novaemu.habbo.rooms.Room;
import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class RoomTextSearchMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		String query = novaEmu.filter(msg.popFixedString().toLowerCase().trim());
		
		List<Room> rooms;
		
		try {
			rooms = novaEmu.getServer().getRooms().getRoomsViaSearch(query);
		
			ServerMessage Response = new ServerMessage(Outgoing.GuestRoomSearchResultComposer);
	
			Response.AppendInt32(0);
			Response.AppendInt32(6);
			Response.AppendStringWithBreak("");
			
			Response.AppendInt32(rooms.size());
			
			for(Room room : rooms) {
				
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
