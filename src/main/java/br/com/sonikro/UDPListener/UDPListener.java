package br.com.sonikro.UDPListener;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.jboss.logging.Logger;

public class UDPListener {
	private static Logger logger = Logger.getLogger(UDPListener.class);
	
	private Integer mListeningPort;
	private PacketHandler mPacketHandler;
	private Integer mPacketSize;
	
	public UDPListener(Integer port)
	{
		this.mListeningPort = port;
	}
	
	public Integer getmListeningPort() {
		return mListeningPort;
	}

	
	
	
	public PacketHandler getmPacketHandler() {
		return mPacketHandler;
	}

	public void setmPacketHandler(PacketHandler mPacketHandler) {
		this.mPacketHandler = mPacketHandler;
	}

	public Integer getmPacketSize() {
		return mPacketSize;
	}

	public void setmPacketSize(Integer mPacketSize) {
		this.mPacketSize = mPacketSize;
	}

	public void preferIPV4()
	{
		System.setProperty("java.net.preferIPv4Stack" , "true");
	}
	public void syncListen() throws Exception
	{
		DatagramSocket socket = new DatagramSocket(mListeningPort);
		logger.info("UDP Listening at : "+mListeningPort);
		byte receivedData[] = new byte[mPacketSize];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
		while(true)
		{
			socket.receive(receivedPacket);
			
			mPacketHandler.handlePacket(receivedPacket);
			
			
			logger.info("Received packet at port " +mListeningPort);
			logger.info("Packet Content: "+new String(receivedPacket.getData()).trim());
			
			if(mPacketHandler.isTerminatorPacket(receivedPacket))
			{
				logger.info("Terminator Packet received, terminating Listener");
				mPacketHandler.onEndOfConnection();
				break;
			}
			
		}
	}
	
	
	
}
