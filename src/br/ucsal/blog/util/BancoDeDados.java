package br.ucsal.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BancoDeDados {
	
	
	public static void main(String[] args) {
		String url = "jdbc:hsqldb:mem:mymemdb";
		String user = "SA";
		String password = "";
		Connection connection = null;
		try {
			 connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Statement statement = connection.createStatement();
			String create = "CREATE TABLE ALUNOS (ID INT PRIMARY KEY," 
						+ "MATRICULA CHAR(20)," 
						+"NOME VARCHAR(250));";		
			statement.execute(create);
			System.out.println("Criou a tabela");
			
			String insert = "INSERT INTO ALUNOS " 
					+ "(ID, MATRICULA, NOME) VALUES (1, '200020242','enzo');" ;		
			statement.execute(insert);
			System.out.println("Inseriu na tabela");
			
			String insert2 = "INSERT INTO ALUNOS " 
					+ "(ID, MATRICULA, NOME) VALUES (2, '300030342','enzo gama');" ;		
			statement.execute(insert2);
			System.out.println("Inseriu na tabela");
			
			int variavel1 = 1;
			String variavel2 = "'' OR 1=1";
			
			Statement select = connection.createStatement();
			String sqldoSelect = "SELECT ID, MATRICULA, NOME FROM ALUNOS WHERE ID="+variavel1+ "AND MATRICULA="+variavel2;
			ResultSet resultSet = select.executeQuery(sqldoSelect);
			//resultSet.next no while faz correr 
			while (resultSet.next()) {
				System.out.println(resultSet.getString(3));//pega a coluna 3 e faz um select nela
			}
			statement.close();
			connection.close();
			
		 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
