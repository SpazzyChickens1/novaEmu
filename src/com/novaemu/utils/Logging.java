package com.novaemu.utils;

public class Logging {

	public static void Fatal(String Text) {
		System.out.println("[ERROR] " + Text);
	}
	
	public static void Write(String Text) {
		System.out.println("[NOVAEMU] " + Text);
	}
}
