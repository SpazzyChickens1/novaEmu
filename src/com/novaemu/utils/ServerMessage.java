package com.novaemu.utils;

import java.nio.charset.Charset;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class ServerMessage
{
	private ChannelBuffer body;

	public ServerMessage() 
	{
	}
	
	public ServerMessage(int id) 
	{
		this.Init(id);
	}

	public void Init(int id)
	{
		this.body = ChannelBuffers.dynamicBuffer();
		this.body.writeBytes(B64Encoding.EncodeInt32(id, 2));
	}

	public void AppendByte(Byte b) {
		this.body.writeByte(b);
	}
	public void AppendChar(int b) {
		this.body.writeByte((byte)b);
	}
	public void AppendBytes(byte[] b) {
		this.body.writeBytes(b);
	}

	public void AppendString(String str) {
		this.body.writeBytes(str.getBytes(Charset.forName("UTF-8")));
	}

	public void appendRawDouble(Double d) {
		Long db = Math.round(d);
		String raw = db.toString();

		if (raw.length() == 1) {
			raw += ".0";
		}

		AppendStringWithBreak(raw.replace(",", "."));
	}

	public void AppendStringWithBreak(String str) {
		AppendStringWithBreak(str, (byte) 2);
	}
	
	public void AppendStringWithBreak(String str, byte breakChar) {
		AppendString(str);
		AppendByte(breakChar);
	}

	public void AppendInt32(int i) {
		AppendBytes(WiredEncoding.EncodeInt32(i));
	}
	public void AppendTinyInt(byte i) {
		AppendBytes(WiredEncoding.EncodeInt32(i));
	}

	public void AppendRawInt(Integer i) {
		AppendString(i.toString());
	}

	public void AppendBoolean(boolean state) {
		this.body.writeByte(state == true ? WiredEncoding.POSITIVE
				: WiredEncoding.NEGATIVE);
	}

	private void writeClosing() {
		this.body.writeByte(1);
	}

	public ChannelBuffer get()
	{
		writeClosing();

		return this.body;
	}
}
