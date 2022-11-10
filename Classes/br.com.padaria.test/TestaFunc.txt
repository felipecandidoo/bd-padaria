package br.com.padaria.test;

import java.sql.SQLException;

import br.com.padaria.DAO.FuncionarioDAO;
import br.com.padaria.model.Funcionario;

public class TestaFunc {

	public static void main(String[] args) {

		testaInsert();
	}
	
	public static void testaInsert() {

		Funcionario func = new Funcionario();

		//atribuindo valores aos atributos do objeto criado

		func.setMatricula(2345);

		func.setNome("Ana Cecilia");

		func.setEndereco("Avenida Rio Branco");

		func.setSexo("F");
		
		func.setCargo("CEO");

		func.setSalario(4000);
		
		FuncionarioDAO empDAO = null;
		
		try {
			
			empDAO = new FuncionarioDAO();
			
		} catch (SQLException e) {

			e.printStackTrace();

			} catch (ClassNotFoundException e) {

			e.printStackTrace();

			}
			
		empDAO.cadastrarFuncionario(func);
		}
}
