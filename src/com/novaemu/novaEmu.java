package com.novaemu;

import com.novaemu.network.*;
import com.novaemu.utils.Logging;

public class novaEmu {

	private static NovaServer novaServer;
	
	public static void main(String[] args) {

		Logging.Write("Loading novaEmulator");
		startServer();
	}
	
	public static void startServer() {
		
		novaServer = new NovaServer("127.0.0.1", 30000);
		getServer().configureNetty();
		
		if(getServer().startServer()) {
			
			Logging.Write("Started the server on port " + getServer().Port);
			
		} else {
			Logging.Fatal("Failed to start the server, make sure port " + getServer().Port + " isn't already in use!");
		}
	}
	
	public static NovaServer getServer() {
		return novaServer;
	}

}
