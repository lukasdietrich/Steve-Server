package org.steve.server.database;

import java.sql.Connection;
import java.util.logging.Level;

import org.steve.server.Logger;


public class Database {

	public static Database instance;
	
	public static Database getInstance() {
		return (instance == null) ? instance = new Database() : instance;
	}
	
	private Connection conn;
	
	public Database() {
		try {
			Class.forName("org.h2.Driver");
			Logger.get(this).log(Level.INFO, "Database is ready");
		} catch (ClassNotFoundException e) {
			Logger.get(this).log(Level.SEVERE, "Database could not start " + e.getMessage());
			System.exit(1);
		}
	}
	
}
