package com.novaemu.habbo.players;

import java.sql.SQLException;
import java.util.List;

import com.novaemu.novaEmu;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ServerMessage;
import com.novaemu.habbo.players.messenger.MessengerManager;
import com.novaemu.habbo.rooms.Room;

public class Habbo {

	public int Id;
	public String Username;
	public String Gender;
	public String Figure;
	public String Motto;
	public int Credits;
	
	public int Rank;
	
	public Boolean Muted;
	
	public Session Session;
	
	public MessengerManager MessengerManager;
	private int ActivityPoints;
	
	public List<Room> Rooms;
	
	public Habbo(Session session, int id, String username, String gender, String figure, String motto, int credits, int pixels) throws SQLException {
		this.Session = session;
		this.Id = id;
		this.Username = username;
		this.Gender = gender;
		this.Figure = figure;
		this.Motto = motto;
		this.Credits = credits;
		this.ActivityPoints = pixels;
		
		this.MessengerManager = new MessengerManager(this);
		
		try {
			this.Rooms = novaEmu.getServer().getRooms().getRoomsByOwner(this.Username);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateCredits(Boolean database) {
		ServerMessage Msg = new ServerMessage(Outgoing.CreditBalanceComposer);
		Msg.AppendStringWithBreak(Credits + ".0");
		   
			this.getSession().send(Msg);
			
			if(database) {
				novaEmu.getServer().getStorage().executeQuery("UPDATE users SET credits = " + Credits + " WHERE id = " + Id);
			}
	}
	
	public void updateActivityPoints(Boolean database) {
		ServerMessage Msg = new ServerMessage(Outgoing.HabboActivityPointNotificationMessageComposer);
		
		Msg.AppendInt32(ActivityPoints);
		Msg.AppendInt32(0); 
		this.getSession().send(Msg);
				
		if(database) {
			if(database) {
				novaEmu.getServer().getStorage().executeQuery("UPDATE users SET credits = " + Credits + " WHERE id = " + Id);
			}
		}
	}
	
	public void toggleMute() {
		if(!this.Muted) {
			this.getSession().sendAlert("You have been muted by a moderator.");
			this.Muted = true;
		} else {
			this.getSession().sendAlert("You have been unmuted by a moderator.");
			this.Muted = false;
		}
	}
	
	public MessengerManager getMessenger() {
		return this.MessengerManager;
	}
	
	public Session getSession() {
		return this.Session;
	}
}
