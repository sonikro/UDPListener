package br.com.sonikro.UDPListener;

public class UDPListenerBuilder {
	private UDPListener mUDPListener;
	private Integer mListeningPort;
	private PacketHandler mPacketHandler;
	private Integer mPacketSize;
	private Boolean mPreferIPV4;
	
	public static UDPListenerBuilder newListener()
	{
		return new UDPListenerBuilder();
	}
	
	public UDPListenerBuilder atPort(Integer port)
	{
		this.mListeningPort = port;
		return this;
	}
	
	public UDPListenerBuilder withPacketHandler(PacketHandler converter)
	{
		this.mPacketHandler = converter;
		return this;
	}
	
	public UDPListenerBuilder packetSize(Integer size)
	{
		this.mPacketSize = size;
		return this;
	}
	
	public UDPListenerBuilder preferIPV4()
	{
		this.mPreferIPV4 = true;
		return this;
	}
	
	public UDPListener build()
	{
		UDPListener listener = new UDPListener(mListeningPort);
		listener.setmPacketHandler(mPacketHandler);
		listener.setmPacketSize(mPacketSize);
		if(mPreferIPV4)
		{
			listener.preferIPV4();
		}
		return listener;
		
	}
	
	
}
