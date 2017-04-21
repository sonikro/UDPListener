package br.com.sonikro.UDPListener;

public class AppTest {
	public static void main(String[] args) throws Exception {
		UDPListener listener = UDPListenerBuilder.newListener()
												 .atPort(45679)
												 .withPacketHandler(new DummyPacketHandler())
												 .packetSize(255)
												 .preferIPV4()
												 .build();
		listener.syncListen();
	}
}
