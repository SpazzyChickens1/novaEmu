package com.novaemu.protocol.navigator;

import com.novaemu.novaEmu;
import com.novaemu.habbo.navigator.FlatCat;
import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class GetUserFlatCatsMessageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		ServerMessage Response = new ServerMessage(Outgoing.UserFlatCatsComposer);
		
		Response.AppendInt32(novaEmu.getServer().getNavigator().getPrivateCategories().size());
		
		for(FlatCat cat : novaEmu.getServer().getNavigator().getPrivateCategories())
		{
			Response.AppendInt32(cat.Id);
			Response.AppendStringWithBreak(cat.Caption);
		}
		
		Client.send(Response);
	}
}
