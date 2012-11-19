package com.novaemu.protocol.players;

import com.novaemu.protocol.IMessageEvent;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;

public class GetCreditsInfoEvent implements IMessageEvent {
	
	@Override
	public void run(ClientMessage msg, Session Client) {
		Client.getPlayer().getHabbo().updateCredits(false);
		Client.getPlayer().getHabbo().updateActivityPoints(false);
	}
}
