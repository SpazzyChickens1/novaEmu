package com.novaemu.protocol.handshake;

import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class InitCryptoMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		ServerMessage Message = new ServerMessage(Outgoing.SessionParamsMessageComposer);
        Message.AppendInt32(0);
		Client.send(Message);
	}

}
