package br.ucsal.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BancoDeDados {
	
	
	public static void main(String[] args) {
		String url = "jdbc:hsqldb:mem:mymemdb";
		String user = "SA";
		String password = "";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
