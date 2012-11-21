package com.novaemu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import com.novaemu.utils.Logging;

public class novaEmu {

	private static NovaServer novaServer;
	private static Properties config;
	
	public static void main(String[] args) {

		Logging.Write("Loading novaEmulator");
		
		try {
			startServer();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void startServer() throws IOException {
		
		InputStream inputStream = new novaEmu().getClass().getResourceAsStream("/nova.properties");  
		
		config = new Properties();
		config.load(inputStream);
		
		novaServer = new NovaServer(config);

		try {
			getServer().loadCache();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		getServer().configureNetty();
		
		if(getServer().startServer()) {
			
			Logging.Write("Started the server on port " + getServer().Port);
			
		} else {
			Logging.Fatal("Failed to start the server, make sure port " + getServer().Port + " isn't already in use!");
		}
	}
	
	public static String filter(String str) {
		str = str.replace((char) 1, ' ');
		str = str.replace((char) 2, ' ');
		str = str.replace((char) 3, ' ');
		str = str.replace((char) 9, ' ');
		
		return str;
	}
	
	public static NovaServer getServer() {
		return novaServer;
	}

}
