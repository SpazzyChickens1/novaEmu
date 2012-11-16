package com.novaemu.utils;

import java.nio.charset.Charset;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class ClientMessage
{
	private Integer id;
	private ChannelBuffer body;

	public ClientMessage(Integer id, ChannelBuffer body) {
		this.id = id;

		if (body == null) {
			this.body = ChannelBuffers.EMPTY_BUFFER;
		} else {
			this.body = body;
		}

		this.body.markReaderIndex();
	}

	public ChannelBuffer readBytes(int len) {
		if (len > this.body.readableBytes()) {
			len = this.body.readableBytes();
		}

		ChannelBuffer buf = this.body.readBytes(len);
		this.body.discardReadBytes();

		return buf;
	}

	public ChannelBuffer readRawBytes(int len) {
		if (len > this.body.readableBytes()) {
			len = this.body.readableBytes();
		}

		ChannelBuffer res = this.body.readBytes(len);
		this.body.resetReaderIndex();

		return res;
	}

	public ChannelBuffer readFixedValue() {
		int b64 = B64Encoding.DecodeInt32(this.readBytes(2).array());
		return this.readBytes(b64);
	}

	public int popInt() {
		return B64Encoding.DecodeInt32(this.readBytes(2).array());
	}

	public int popFixedInt() {
		int i = 0;
		String s = this.popFixedString();

		i = Integer.parseInt(s);

		return i;
	}

	public int PopWiredInt32() {
		if (this.body.readableBytes() < 1) {
			return 0;
		}

		byte[] vl64 = this.readRawBytes(WiredEncoding.MAX_INTEGER_BYTE_AMOUNT)
				.array();

		int i = WiredEncoding.DecodeInt32(vl64, 0);
		byte[] totalBytes = WiredEncoding.EncodeInt32(i);

		this.body.readBytes(totalBytes.length);
		this.body.discardReadBytes();

		return i;
	}

	public String popFixedString() {
		return new String(this.readFixedValue().toString(
				Charset.defaultCharset()));
	}

	public boolean popBase64Boolean() {
		if (this.body.readableBytes() > 0
				&& this.body.readByte() == B64Encoding.POSITIVE) {

			return true;
		}

		return false;
	}

	public boolean popWiredBoolean() {
		if (this.body.readableBytes() > 0
				&& this.body.readByte() == WiredEncoding.POSITIVE) {

			return true;
		}

		return false;
	}

	public int getType() {
		return this.id;
	}

	public String getHeader() {
		return new String(B64Encoding.EncodeInt32(this.getType(), 2));
	}

	public String getBodyString() {
		return new String(this.body.toString(Charset.defaultCharset()));
	}

	public int getCurrentLength() {
		return this.body.readableBytes();
	}
}
