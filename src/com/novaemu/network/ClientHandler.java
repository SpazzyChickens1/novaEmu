package com.novaemu.network;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import com.novaemu.novaEmu;
import com.novaemu.sessions.Session;
import com.novaemu.utils.Logging;

public class ClientHandler extends SimpleChannelHandler {

	@Override
	public void channelOpen(ChannelHandlerContext ctnx, ChannelStateEvent e) {
		
		Logging.Write("Connection recieved from " + ctnx.getChannel().getRemoteAddress().toString());
		
		if(!novaEmu.getServer().getSessionManager().addSession(ctnx.getChannel())) {
			ctnx.getChannel().disconnect();
		}
	}
	
	@Override
	public void channelClosed(ChannelHandlerContext ctnx, ChannelStateEvent e) {
		
		Logging.Write("Connection closed from " + ctnx.getChannel().getRemoteAddress().toString());
		
		novaEmu.getServer().getSessionManager().removeSession(ctnx.getChannel());
		
	}
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		
		Session session = (Session)ctx.getAttachment();
		
		Logging.Write("Recieved message from " + session.getChannel().getRemoteAddress().toString());
		
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
		ctx.getChannel().close();
	}
}
