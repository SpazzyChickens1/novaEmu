package com.novaemu.habbo.items;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.novaemu.novaEmu;
import com.novaemu.utils.Logging;

public class ItemManager {
	public Map<Integer, Item> items;
	
	public ItemManager() throws SQLException {
		this.items = new HashMap<Integer, Item>();
		
		ResultSet item = novaEmu.getServer().getStorage().readTable("SELECT * FROM furniture");
		
		while(item.next()) {
			
			Item i = new Item(item.getInt("id"), item.getInt("sprite_id"), item.getString("public_name"), item.getString("item_name"), item.getString("type"));
			this.items.put(i.Id, i);
		}
	}
	
	public Item getItem(int id) {
		if(this.items.containsKey(id)) {
			return items.get(id);
		} else {
			Logging.Fatal("One does not simply get an item without a definition.");
			return null;
		}
	}
}
