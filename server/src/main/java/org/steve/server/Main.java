package org.steve.server;

import java.io.File;
import java.net.InetAddress;

import org.steve.server.httpd.HttpServer;
import org.steve.server.websocket.SocketServer;

/**
 * Hello world!
 *
 */
public class Main {
	
	public static void main( String[] args ) throws Exception {
		int porthttp = 9878, portsocket = 9879;
		
		for(String arg : args) {
			arg = arg.toLowerCase();
			
			if(arg.equals("debug"))
				org.eclipse.jetty.util.log.Log.getLog().setDebugEnabled(true);
			else if(arg.startsWith("http="))
				porthttp = Integer.parseInt(arg.substring(5));
			else if(arg.startsWith("websocket="))
				portsocket = Integer.parseInt(arg.substring(10));
		}
	
		new HttpServer(new File("www/"), porthttp, true);
		new SocketServer(portsocket);
	
		System.out.println("HTTP server @ "+ InetAddress.getLocalHost().getHostAddress() + ":" + porthttp);
		System.out.println("WEBSOCKET server @ "+ InetAddress.getLocalHost().getHostAddress() + ":" + portsocket);
	}
}
