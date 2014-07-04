package com.parlect.pk.handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.parlect.pk.Client;
import com.parlect.pk.Start;

public class ConnectionHandler implements Runnable {

	public final Map<Integer, Client> connections = new HashMap<Integer, Client>();
	
	@Override
	public void run() {
		
		ServerSocket var1 = Start.server;
		
		while (Start.running) {
			try {
				
				Socket varSocket1 = var1.accept();
				Client varClient1 = new Client(varSocket1, connections.size());
				
				connections.put(varClient1.getIdentifier(), varClient1);
				new Thread(varClient1).start();
				
			} catch (IOException e) {
				System.out.println(e);
			}	
			
		}
		
	}

	public final void remove(int par1) {
		connections.remove(par1);
	}
	
}
