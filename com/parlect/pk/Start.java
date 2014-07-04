package com.parlect.pk;

import java.io.IOException;
import java.net.ServerSocket;

import com.parlect.pk.handler.ConnectionHandler;

public final class Start {
	
	public static final String name = "Nacorpio's Server";
	public static final String welcome = "Welcome to " + name + ".";
	
	public static boolean running = true;

	public static int PORT = 1235;
	public static ServerSocket server;
	
	public static ConnectionHandler connectionHnd;
	
	public static void main(String[] args) {
		try {
			
			connectionHnd = new ConnectionHandler();
			
			server = new ServerSocket(PORT);
			running = true;
			
			display("Started server");
				
			new Thread(connectionHnd).start();
			
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

	public static final void display(String par1) {
		if (par1 != null)
			System.out.println(par1);
	}
	
}
