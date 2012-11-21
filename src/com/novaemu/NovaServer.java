package com.novaemu;

import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.novaemu.habbo.navigator.Navigator;
import com.novaemu.habbo.rooms.RoomManager;
import com.novaemu.network.ClientHandler;
import com.novaemu.network.codec.Decoder;
import com.novaemu.network.codec.Encoder;
import com.novaemu.protocol.MessageHandler;
import com.novaemu.sessions.SessionManager;
import com.novaemu.storage.StorageManager;
import com.novaemu.utils.Logging;

public class NovaServer {

	private NioServerSocketChannelFactory channelFactory;
	private ServerBootstrap serverBootstrap;

	public SessionManager sessionManager;
	
	public MessageHandler messageHandler;
	
	public String IP;
	public int Port;
	
	public Properties config;
	private StorageManager storageManager;
	
	public Navigator navigator;
	public RoomManager rooms;
	
	public NovaServer(Properties config)
	{		
		this.config = config;
		this.IP = config.getProperty("game.host");
		this.Port = Integer.parseInt(config.getProperty("game.port"));
		
		this.channelFactory = new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool()
		);
		
		this.serverBootstrap = new ServerBootstrap(this.channelFactory);
		
		this.startUp();
	}
	
	public void startUp() {
		
		this.sessionManager = new SessionManager();
		Logging.Write("Loaded the session manager");
		
		this.messageHandler = new MessageHandler();
		Logging.Write("Loaded " + getMessages().getEvents().size() + " messages!");
		
		this.storageManager = new StorageManager("jdbc:mysql://" +  config.getProperty("mysql.host") +"/" + config.getProperty("mysql.database"), config.getProperty("mysql.username"), config.getProperty("mysql.password"));
		Logging.Write("MySQL database connection has been made.");
	}
	
	public void loadCache() throws SQLException {
		this.navigator = new Navigator();
		Logging.Write("Loaded " + getNavigator().getPrivateCategories().size() + " private room categories.");
		
		this.rooms = new RoomManager();
		Logging.Write("Loaded room manager.");
		
	}
	
	public void configureNetty()
	{
		ChannelPipeline pipeline = this.serverBootstrap.getPipeline();
		
		pipeline.addLast("encoder", new Encoder());
		pipeline.addLast("decoder", new Decoder());
		pipeline.addLast("handler", new ClientHandler());
	}
	
	public boolean startServer()
	{
		try {
			this.serverBootstrap.bind(new InetSocketAddress(this.IP, this.Port));
		} catch(ChannelException e) {
			return false;
		}
		return true;
	}
	
	public MessageHandler getMessages() {
		return this.messageHandler;
	}
	
	public RoomManager getRooms() {
		return this.rooms;
	}
	
	public SessionManager getSessionManager() {
		return this.sessionManager;
	}

	public Navigator getNavigator() {
		return navigator;
	}
	
	public StorageManager getStorage() {
		return storageManager;
	}
}
