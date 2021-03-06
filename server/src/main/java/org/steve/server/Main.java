package org.steve.server;

import java.io.File;
import java.net.InetAddress;

import org.steve.server.database.Database;
import org.steve.server.httpd.HttpServer;
import org.steve.server.websocket.SocketServer;

/**
 * @author Lukas
 *
 */
public class Main {
	
	public static void main( String[] args ) throws Exception {
		Database.getInstance();
		
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
	
		new HttpServer(new File("Steve-Client/client/"), porthttp, true);
		new SocketServer(portsocket);
	
		System.out.println("HTTP server @ "+ InetAddress.getLocalHost().getHostAddress() + ":" + porthttp);
		System.out.println("WEBSOCKET server @ "+ InetAddress.getLocalHost().getHostAddress() + ":" + portsocket);
	}
	
}
