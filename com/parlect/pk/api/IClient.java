package com.parlect.pk.api;

import java.net.Socket;
import java.util.List;

import com.parlect.pk.rank.EnumRank;

public interface IClient {

	/**
	 * Returns the alias that has been set by the user manually.
	 * @return the alias.
	 */
	String getTempAlias();
	
	/**
	 * Returns the IP-address of the client.
	 * @return the IP-address.
	 */
	String getIPAddress();
	
	/**
	 * Returns the commands that has been sent recently.
	 * @return recent commands.
	 */
	List<String> getRecent();
	
	/**
	 * Returns the socket of the client.
	 * @return the socket.
	 */
	Socket getSocket();
	
	/**
	 * Returns the rank of the client.
	 * @return the rank.
	 */
	EnumRank getRank();
	
}
