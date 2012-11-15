package com.novaemu.network.codec;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.novaemu.utils.Logging;

public class Decoder extends FrameDecoder {

	@Override
	protected Object decode(ChannelHandlerContext Context, Channel channel,
			ChannelBuffer buffer) throws Exception {

		if (buffer.readableBytes() < 6)
			return null;
		
		byte[] Length = buffer.readBytes(4).array();
 
		if (Length[0] == 60)
		{
			buffer.discardReadBytes();

			channel.write("<?xml version=\"1.0\"?>\r\n"
				+ "<!DOCTYPE cross-domain-policy SYSTEM \"/xml/dtds/cross-domain-policy.dtd\">\r\n"
				+ "<cross-domain-policy>\r\n"
				+ "<allow-access-from domain=\"*\" to-ports=\"*\" />\r\n"
				+ "</cross-domain-policy>\0");
			
			Logging.Write("Sent policy");
		}
		else
		{
			// Packet handling..
			channel.write("BKLol! :D" + (char)1);
		}

		return null;
	}


}
