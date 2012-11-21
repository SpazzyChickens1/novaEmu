package com.novaemu.habbo.navigator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.novaemu.novaEmu;

public class Navigator {

	private List<FlatCat> PrivateCategories;
	
	public Navigator() throws SQLException {
		this.setPrivateCategories(new ArrayList<FlatCat>());
		this.loadPrivateCategories();		
	}
	
	public void loadPrivateCategories() throws SQLException {
		
		ResultSet Row = novaEmu.getServer().getStorage().readTable("SELECT * FROM navigator_flatcats WHERE enabled = '1'");

		while(Row.next()) {
			FlatCat cat = new FlatCat(Row.getInt("id"), Row.getString("caption"), true);
			this.getPrivateCategories().add(cat);
		}
	}

	public List<FlatCat> getPrivateCategories() {
		return PrivateCategories;
	}

	public void setPrivateCategories(List<FlatCat> privateCategories) {
		PrivateCategories = privateCategories;
	}
	
}
