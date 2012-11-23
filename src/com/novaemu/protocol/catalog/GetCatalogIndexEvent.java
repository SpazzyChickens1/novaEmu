package com.novaemu.protocol.catalog;

import com.novaemu.novaEmu;
import com.novaemu.habbo.catalog.types.CatalogPage;
import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class GetCatalogIndexEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		ServerMessage response = new ServerMessage(Outgoing.CatalogIndexMessageComposer);
		
		response.AppendInt32(1);
		response.AppendInt32(0);
		response.AppendInt32(0);
		response.AppendInt32(-1);
		response.AppendStringWithBreak("");
		
		response.AppendInt32(catCount(-1));
		
		for(CatalogPage page : novaEmu.getServer().getCatalog().getPages().values()) {
			if(page.ParentId != -1) {
				continue;
			}
			
			response.AppendBoolean(true);
			response.AppendInt32(page.Colour);
			response.AppendInt32(page.Icon);
			response.AppendInt32(page.Id);
			response.AppendStringWithBreak(page.Caption);
			response.AppendInt32(catCount(page.Id));
			
			for(CatalogPage child : novaEmu.getServer().getCatalog().getPages().values()) {
				
				if(child.ParentId != page.Id){
					continue;
				}
				
				response.AppendBoolean(true);
				response.AppendInt32(child.Colour);
				response.AppendInt32(child.Icon);
				response.AppendInt32(child.Id);
				response.AppendStringWithBreak(child.Caption);
				response.AppendInt32(0);
			}
		}
		
		Client.send(response);
	}
	
	public int catCount(int parent) {
		int i = 0;
		
		for(CatalogPage page : novaEmu.getServer().getCatalog().getPages().values())
		{
			if(page.ParentId == parent) {
				i++;
			}
		}
		
		return i;
	}

}
