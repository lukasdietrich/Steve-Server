package org.steve.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;

public class Logger {

	private static ArrayList<String> registered = new ArrayList<String>();
	private static FileHandler handler;
	
	static {
		try {
			handler = new FileHandler("steve.log", false);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static java.util.logging.Logger get(Object context) {
		java.util.logging.Logger logger;
		String name;
		
		if(context instanceof Class<?>) 
			name = ((Class<?>) context).getName();
		else 
			name = context.getClass().getName();
		
		logger = java.util.logging.Logger.getLogger(name);
		
		if(!registered.contains(name)) {
			logger.addHandler(handler);
			registered.add(name);
		}
		
		return logger;
	}
	
}
