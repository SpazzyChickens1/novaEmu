package com.novaemu.protocol.messenger;

import com.novaemu.novaEmu;
import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class SendMsgMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		int toId = msg.PopWiredInt32();
		Session to = novaEmu.getServer().getSessionManager().getClientByHabbo(toId);
		
		if(to.getPlayer().getHabbo() != null) {
			
			ServerMessage Response = new ServerMessage(Outgoing.NewConsoleMessageComposer);
			Response.AppendInt32(Client.getPlayer().getHabbo().Id);
			Response.AppendStringWithBreak(msg.popFixedString());
			
			to.send(Response);
		} else {
			Client.sendAlert("That message failed to send.");
		}
		
	}

}
