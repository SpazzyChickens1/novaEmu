package com.novaemu.protocol;

import com.novaemu.protocol.composers.Incoming;
import com.novaemu.protocol.handshake.InitCryptoMessageEvent;

import java.util.HashMap;
import java.util.Map;

import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.Logging;

public class MessageHandler {

	private Map<Integer, IMessageEvent> events;
	
	public MessageHandler() {
		this.events = new HashMap<Integer, IMessageEvent>();
		
		this.registerPackets();
	}
	
	public void registerPackets() {
		
		this.getEvents().put(Incoming.InitCryptoMessageEvent, new InitCryptoMessageEvent());

	}
	
	public void handlePacket(ClientMessage msg, Session session) {
		
		if(getEvents().containsKey(msg.getType())) {
						
			Logging.Write("Handled packet -> [" + Incoming.valueOfId(msg.getType()) + "][" + msg.getHeader() + "]");

			getEvents().get(msg.getType()).run(msg, session);
			
		} else {
			
			Logging.Fatal("Unhandled packet -> [" + Incoming.valueOfId(msg.getType()) + "][" + msg.getHeader() + "]");

		}
	}
	
	public Map<Integer, IMessageEvent> getEvents() {
		return this.events;
	}
	
}
