
package coap.exam01.server;

//리소스는 센서들을 얘기함

import java.net.InetSocketAddress;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;

public class CoapResourceSever {
	//Field
	private CoapServer coapServer;
	
	//Constructor
	public CoapResourceSever(){
		coapServer = new CoapServer();
		InetSocketAddress isa=new InetSocketAddress("192.168.3.52",5683);
		coapServer.addEndpoint(new CoapEndpoint(isa));
		coapServer.add(new CoapResource01()); //관리할 센서들을 여기서 등록해줌
		coapServer.start(); //서버시작
	}
	//Method
	
	public void shutdown(){
		coapServer.stop();
		coapServer.destroy();
	}
	
	public static void main(String[] args) {
		CoapResourceSever server = new CoapResourceSever();
		System.out.println("CoAP server is listening on port 5683");
	}

}
