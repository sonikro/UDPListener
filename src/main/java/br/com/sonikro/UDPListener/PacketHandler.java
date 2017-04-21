package br.com.sonikro.UDPListener;

import java.net.DatagramPacket;

public interface PacketHandler {
	void handlePacket(DatagramPacket packet);
	boolean isTerminatorPacket(DatagramPacket packet); //Terminates Listener Connection
	void onEndOfConnection();
}
