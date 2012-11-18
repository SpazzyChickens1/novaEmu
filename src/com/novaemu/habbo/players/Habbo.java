package com.novaemu.habbo.players;

public class Habbo {

	public int Id;
	public String Username;
	public String Gender;
	public String Figure;
	public String Motto;
	public int Credits;
	
	public Habbo(int id, String username, String gender, String figure, String motto, int credits) {
		this.Id = id;
		this.Username = username;
		this.Figure = figure;
		this.Motto = motto;
		this.Credits = credits;
	}
}
