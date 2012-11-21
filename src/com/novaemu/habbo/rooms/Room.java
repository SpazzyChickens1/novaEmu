package com.novaemu.habbo.rooms;

import java.util.HashMap;
import java.util.Map;

import com.novaemu.sessions.Session;

public class Room {

	public int Id;
	public String Name;
	public String Description;
	public String Password;
	public int Rating;
	public String Owner;
	public int Status;
	public int Category;
	public String Wallpaper;
	public String Floorpaper;
	public String Landscape;
	public Boolean Disposed;
	public String Thumbnail;
	public Map<Integer, Session> Clients;
	public String[] Tags;

	public Room(int Id, String Name, String Description, String Password, int Rating, String Owner, int Status, int Category, String Wallpaper, String Floorpaper, String Landscape, boolean Disposed, String Thumbnail, String tags)
	{
		this.Id = Id;
		this.Name = Name;
		this.Description = Description;
		this.Password = Password;
		this.Rating = Rating;
		this.Owner = Owner;
		this.Status = Status;
		this.Category = Category;
		this.Wallpaper = Wallpaper;
		this.Floorpaper = Floorpaper;
		this.Landscape = Landscape;
		this.Disposed = Disposed;
		this.Thumbnail = Thumbnail;
		this.Tags = tags.split(",");
		
		this.Clients = new HashMap<Integer, Session>();
	}
}
