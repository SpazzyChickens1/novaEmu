package com.novaemu.habbo.players.messenger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.novaemu.novaEmu;
import com.novaemu.habbo.players.Habbo;

public class MessengerManager {
	
	private Habbo habbo;
	
	private Map<Integer, Friend> Friends;	
	
	public MessengerManager(Habbo habbo) {
		this.habbo = habbo;
		this.Friends = new HashMap<Integer, Friend>();
	}
	
	public void loadBuddies() throws SQLException {
		
		ResultSet Row = novaEmu.getServer().getStorage().readTable("SELECT * FROM messenger_friendships WHERE user_one_id = " + habbo.Id);
		while(Row.next()) {
			Friend buddy = new Friend(Row.getInt("user_two_id"));
			this.getFriends().put(buddy.Id, buddy);
		}
	}
	
	public Map<Integer, Friend> getFriends() {
		return this.Friends;
	}
	
}
