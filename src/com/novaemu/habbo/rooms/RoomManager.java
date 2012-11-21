package com.novaemu.habbo.rooms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.novaemu.novaEmu;

public class RoomManager {

	public HashMap<Integer, Room> Rooms;
	
	public RoomManager() {
		this.Rooms = new HashMap<Integer, Room>();
	}

	public void addRoom(Room room) {
		this.getRooms().put(room.Id, room);
	}
		
	public Room generateRoom(ResultSet data) throws SQLException {
		Room instance = new Room(data.getInt("id"), data.getString("caption"), data.getString("description"), data.getString("password"), data.getInt("score"), data.getString("owner"), data.getInt("users_now"), data.getInt("category"), data.getString("wallpaper"), data.getString("floor"), data.getString("landscape"), false, "", data.getString("tags"));
		return instance;
	}
	
	public List<Room> getRoomsByOwner(String username) throws SQLException {
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		ResultSet Row = novaEmu.getServer().getStorage().readTable("SELECT * FROM rooms WHERE owner = '" + novaEmu.filter(username) + "'");
		
		while(Row.next()) {
			rooms.add(this.generateRoom(Row));
		}
		
		return rooms;
	}
	
	public List<Room> getRoomsViaSearch(String query) throws SQLException {
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		ResultSet Row = novaEmu.getServer().getStorage().readTable("SELECT * FROM rooms WHERE caption LIKE '%" + query + "%'");
		
		while(Row.next()) {
			rooms.add(this.generateRoom(Row));
		}
		
		return rooms;
	}
	
	public HashMap<Integer, Room> getRooms() {
		return this.Rooms;
	}
}
