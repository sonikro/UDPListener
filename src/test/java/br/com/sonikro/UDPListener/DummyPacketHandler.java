package br.com.sonikro.UDPListener;

import java.net.DatagramPacket;

public class DummyPacketHandler implements PacketHandler{

	public void handlePacket(DatagramPacket packet) {
		System.out.println(new String(packet.getData()).trim());
		
	}

	public boolean isTerminatorPacket(DatagramPacket packet) {
		String packetString = new String(packet.getData()).trim();
		if(packetString.contains("#end#"))
		{
			return true;
		}
		return false;
	}

	public void onEndOfConnection() {
		// TODO Auto-generated method stub
		
	}

}
