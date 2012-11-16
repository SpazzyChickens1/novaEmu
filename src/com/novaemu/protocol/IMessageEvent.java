package com.novaemu.protocol;

import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;

public interface IMessageEvent {

	public void run(ClientMessage msg, Session Client);
	
}
