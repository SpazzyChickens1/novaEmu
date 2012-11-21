package com.novaemu.protocol;

import com.novaemu.protocol.composers.Incoming;
import com.novaemu.protocol.handshake.InitCryptoMessageEvent;
import com.novaemu.protocol.handshake.SSOTicketMessageEvent;
import com.novaemu.protocol.messenger.MessengerInitMessageEvent;
import com.novaemu.protocol.messenger.SendMsgMessageEvent;
import com.novaemu.protocol.navigator.GetUserFlatCatsMessageEvent;
import com.novaemu.protocol.navigator.MyRoomsSearchMessageEvent;
import com.novaemu.protocol.navigator.RoomTextSearchMessageEvent;
import com.novaemu.protocol.players.GetCreditsInfoEvent;
import com.novaemu.protocol.players.InfoRetrieveMessageEvent;
import com.novaemu.protocol.players.ScrGetUserInfoMessageEvent;

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
		
		// Handshake message events
		this.getEvents().put(Incoming.InitCryptoMessageEvent, new InitCryptoMessageEvent());
		this.getEvents().put(Incoming.SSOTicketMessageEvent, new SSOTicketMessageEvent());
		
		// Player message events
		this.getEvents().put(Incoming.InfoRetrieveMessageEvent, new InfoRetrieveMessageEvent());
		this.getEvents().put(Incoming.GetCreditsInfoEvent, new GetCreditsInfoEvent());
		this.getEvents().put(Incoming.ScrGetUserInfoMessageEvent, new ScrGetUserInfoMessageEvent());
		
		// Messenger message events
		this.getEvents().put(Incoming.MessengerInitMessageEvent, new MessengerInitMessageEvent());
		this.getEvents().put(Incoming.SendMsgMessageEvent, new SendMsgMessageEvent());
		
		// Navigator message events
		this.getEvents().put(Incoming.GetUserFlatCatsMessageEvent, new GetUserFlatCatsMessageEvent());
		this.getEvents().put(Incoming.MyRoomsSearchMessageEvent, new MyRoomsSearchMessageEvent());
		this.getEvents().put(Incoming.RoomTextSearchMessageEvent, new RoomTextSearchMessageEvent());
	}
	
	public void handlePacket(ClientMessage msg, Session session) {
		
		if(getEvents().containsKey(msg.getType())) {
			if(msg.getHeader() != "D{") {
				Logging.Write("Handled packet -> [" + Incoming.valueOfId(msg.getType()) + "][" + msg.getHeader() + "]");
			
				try {
					
					getEvents().get(msg.getType()).run(msg, session);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			if(Incoming.valueOfId(msg.getType()) != "LatencyPingRequestMessageEvent")
				Logging.Write("Unhandled packet -> [" + Incoming.valueOfId(msg.getType()) + "][" + msg.getHeader() + "]");
		}
	}
	
	public Map<Integer, IMessageEvent> getEvents() {
		return this.events;
	}
	
}
