package com.parlect.pk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.parlect.pk.api.IClient;
import com.parlect.pk.format.CommandFormat;
import com.parlect.pk.handler.CommandHandler;
import com.parlect.pk.rank.EnumRank;

public class Client implements IClient, Runnable {

	private Socket socket;
	private int identifier;
	
	public long connection_time;
	
	private List<String> r_msg = new ArrayList<String>();
	private EnumRank rank = EnumRank.GUEST;
	
	private String alias = "CLIENT[" + identifier + "]";
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	public Client(Socket par1, int par2) {
		
		this.socket = par1;
		this.identifier = par2;
		
		try {
			this.input = new ObjectInputStream(socket.getInputStream());
			this.output = new ObjectOutputStream(socket.getOutputStream());
		}
		
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Username of the client
		try {
			
			// output.writeObject(Start.name);
			
			long connection_time = input.readLong();
			String var1 = (String) input.readObject();
			
			output.writeObject(Start.name);
			output.writeObject(Start.welcome);			
			
			this.alias = var1;
			
			Start.display(alias + " connected to the server (" + this.getIdentifier() + ")");
			
		}
		
		catch (ClassNotFoundException e) {
		} catch (IOException e) {
			Start.display("Can not read the streams");
		}
		
		this.connection_time = System.currentTimeMillis();
		
	}	
	
	public ObjectInputStream getInputStream() throws IOException {
		return new ObjectInputStream(socket.getInputStream());
	}
	
	public ObjectOutputStream getOutputStream() throws IOException {
		return new ObjectOutputStream(socket.getOutputStream());
	}
	
	public final int getIdentifier() {
		return identifier;
	}
	
	@Override
	public String getTempAlias() {
		return alias;
	}

	@Override
	public String getIPAddress() {
		return socket.getInetAddress().toString();
	}

	@Override
	public List<String> getRecent() {
		return r_msg;
	}

	@Override
	public Socket getSocket() {
		return this.socket;
	}

	@Override
	public EnumRank getRank() {
		return rank;
	}

	@Override
	public void run() {
		
		Start.display("Initialized loop for " + this.getTempAlias());
		
		// Run the loop while it's still open.
		boolean running = true;
		while (running) {
			
			String message;
			
			try {
				message = (String) input.readObject();
				if (CommandFormat.isCommand(message)) {
					CommandHandler.onCommandReceived(this.identifier, message);
				} else {
					Start.display(alias + ": " + message);
				}	
			}
			
			catch (ClassNotFoundException e) {
				break;
			} catch (IOException e) {
				if (socket.isClosed()) {
					break;
				}
				Start.display("Can not read the streams (" + e.toString() + ").");
				break;
			}		
			
		}
		
		// Remove the connection from the handler.
		Start.display(this.getTempAlias() + " disconnected");
		Start.connectionHnd.remove(identifier);
		
		disconnect();
		
	}

	public final void send(String par1) {
		
		if (!socket.isConnected()) {
			disconnect();
		}
		
		try {
			output.writeObject(par1);
		}
		
		catch (IOException e) {
			Start.display("Could not write data to " + alias);
			Start.display(e.toString());
		}
		
	}
	
	public final void disconnect() {
		
		try {
			if (input != null) input.close();
			if (output != null) output.close();
			if (socket != null) socket.close();
		}
		
		catch (IOException e) {
			Start.display("Couldn't close the streams");
			return;
		}
		
	}
	
}
