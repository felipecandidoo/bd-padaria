package br.com.padaria.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.padaria.connection.Conecta;
import br.com.padaria.model.Funcionario;

public class FuncionarioDAO {
	
	private Connection con;
	
	
	public FuncionarioDAO() throws SQLException, ClassNotFoundException {
		
		con = Conecta.criarConexao();
	}

	public void cadastrarFuncionario(Funcionario func) {

		String sql = "INSERT INTO funcionario (matricula, nome, endereco, sexo, cargo, salario) VALUES (?,?,?,?,?,?)";
	

		try { 

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, func.getMatricula());

			preparador.setString(2, func.getNome());
			
			preparador.setString(3, func.getEndereco());

			preparador.setString(4, func.getSexo());
			
			preparador.setString(5, func.getCargo());

			preparador.setDouble(6, func.getSalario());			
			
			preparador.execute(); 

			preparador.close();
			
			System.out.println("Inser��o realizada!"); 

			} catch (SQLException e) {

				System.out.println("Erro - " + e.getMessage());

			}

	}
		
		
	public void updateFuncionario(int mat, double sal) {

		String sql = "UPDATE funcionario SET salario = ? WHERE matricula = ?";

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		preparador.setDouble(1, sal);

		preparador.setInt(2, mat);

		preparador.execute();

		preparador.close();

		System.out.println("Altera��o realizada!");

		} catch (SQLException e) {

		System.out.println("Erro - "+ e.getMessage());
		
	
}
	}
	
	public void deleteFuncionario (int mat) {

		String sql = "DELETE FROM empregado WHERE matricula = ?";

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		preparador.setInt(1, mat);

		preparador.execute();

		preparador.close();

		System.out.println("Dele��o realizada!");

		} catch (SQLException e) {

		System.out.println("Erro - "+ e.getMessage());

		}
		}
	
	public List<Funcionario> selectTodos(){

		String sql = "SELECT * FROM funcionario";

		List<Funcionario> lista = new ArrayList<Funcionario>();

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		ResultSet resultados = preparador.executeQuery();

		while (resultados.next()) {
			
			Funcionario func2 = new Funcionario();

			func2.setMatricula(resultados.getInt("matricula"));

			func2.setNome(resultados.getString("nome"));

			func2.setEndereco(resultados.getString("endereco"));
		
			func2.setSexo(resultados.getString("sexo"));

			func2.setCargo(resultados.getString("cargo"));

			func2.setSalario(resultados.getDouble("salario"));


			lista.add(func2);

		} 

		} catch (SQLException e) {

		System.out.println("Erro - " + e.getMessage());

		}

		return lista; 

		} 
	
	
}
