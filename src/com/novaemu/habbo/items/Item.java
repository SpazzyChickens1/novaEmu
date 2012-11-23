package com.novaemu.habbo.items;

public class Item {

	public int Id;
	public int SpriteId;
	public String PublicName;
	public String ItemName;
	public String Type;
	
	public Item(int id, int spriteId, String publicName, String itemName, String type) {
		this.Id = id;
		this.SpriteId = spriteId;
		this.PublicName = publicName;
		this.ItemName = itemName;
		this.Type = type;
	}
}
