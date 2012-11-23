package com.novaemu.protocol.catalog;

import com.novaemu.novaEmu;
import com.novaemu.habbo.catalog.types.CatalogItem;
import com.novaemu.habbo.catalog.types.CatalogPage;
import com.novaemu.protocol.IMessageEvent;
import com.novaemu.protocol.composers.Outgoing;
import com.novaemu.sessions.Session;
import com.novaemu.utils.ClientMessage;
import com.novaemu.utils.ServerMessage;

public class GetCatalogPageEvent implements IMessageEvent {

	@Override
	public void run(ClientMessage msg, Session Client) {
		
		int pageId = msg.PopWiredInt32();
		
		CatalogPage page = novaEmu.getServer().getCatalog().getPage(pageId);
		
		ServerMessage response = new ServerMessage(Outgoing.CatalogPageMessageComposer);
		
		response.AppendInt32(page.Id);
		
		switch(page.Template) {
		
			default:
				response.AppendStringWithBreak(page.Template);
				response.AppendInt32(page.Headlines.length);
				
				for(String headline : page.Headlines){
					response.AppendStringWithBreak(headline);
				}
				
				response.AppendInt32(page.Teasers.length);
				
				for(String teaser : page.Teasers){
					response.AppendStringWithBreak(teaser);
				}
				
				response.AppendInt32(page.Items.size());
				
				for(CatalogItem item : page.Items) {
					
					response.AppendInt32(item.Id);
					response.AppendStringWithBreak(item.DisplayName);
					response.AppendInt32(item.CostCredits);
					response.AppendInt32(item.CostPixels);
					response.AppendInt32(item.CostOther);
					response.AppendInt32(1);
					response.AppendStringWithBreak(item.getDefinition().Type);
					response.AppendInt32(item.getDefinition().SpriteId);
					response.AppendStringWithBreak("");
					response.AppendInt32(item.Amount);
					response.AppendInt32(-1);
					response.AppendInt32(0);
				}
				
				response.AppendInt32(-1);				
				break;
				
			case "frontpage":
				
				 response.AppendStringWithBreak("frontpage3");
                 response.AppendInt32(3);
                 response.AppendStringWithBreak("catalogue");
                 response.AppendStringWithBreak("ts_saturn_pixelcollectible2");
                 response.AppendStringWithBreak("");
                 response.AppendStringWithBreak("SB");
                 response.AppendStringWithBreak("Welcome to the catalogue! We're updating it constantly.");
                 response.AppendStringWithBreak("Powered by novaEmulator 3.0");
                 response.AppendStringWithBreak("Click here to learn more...How to get Habbo CreditsYou can get Habbo Credits via Home Phone, Credit Card, Text Messaging, completing offers and more!");
                 response.AppendByte((byte)3);
                 response.AppendStringWithBreak("To redeem your Habbo Prepaid Card enter your voucher code below.Redeem a voucher code here:Jukebox#FEFEFE#FEFEFEWant all the options?  Click here!magic.creditsHM");
                 
				break;
		}
		
		Client.send(response);
	}

}
