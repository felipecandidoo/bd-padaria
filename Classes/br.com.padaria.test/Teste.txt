package br.com.padaria.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.padaria.connection.Conecta;


public class Teste {
	
	public static void main(String[] args) {
		
		try {
			Connection con = Conecta.criarConexao();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}