package com.novaemu.protocol.players;

import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class ScrGetUserInfoMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
			ServerMessage Message = new ServerMessage(Outgoing.ScrSendUserInfoComposer);
		
			Message.AppendStringWithBreak(msg.popFixedString());
			Message.AppendInt32(0);
			Message.AppendInt32(0);
			Message.AppendInt32(0);
			Message.AppendBoolean(true);

			Client.send(Message);

	}

}
