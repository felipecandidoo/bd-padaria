package br.com.padaria.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.padaria.connection.Conecta;
import br.com.padaria.model.Produto;

public class ProdutoDAO {
	
	private Connection con;
	
	
	public ProdutoDAO() throws SQLException, ClassNotFoundException {
		
		con = Conecta.criarConexao();
	}
	

	public void cadastrarProduto(Produto prod) {

		String sql = "INSERT INTO produto (codigo, nomeP, categoria, estoque, preco) VALUES (?,?,?,?,?)";
	

		try { 

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, prod.getCodigo());

			preparador.setString(2, prod.getNomeP());
			
			preparador.setString(3, prod.getCategoria());

			preparador.setInt(4, prod.getEstoque());
			
			preparador.setDouble(5, prod.getPreco());			
			
			preparador.execute(); 

			preparador.close();
			
			System.out.println("Inser��o realizada!"); 

			} catch (SQLException e) {

				System.out.println("Erro - " + e.getMessage());

			}

		}
		
	public void updateProduto(int id, int qnt) {

		String sql = "UPDATE produto SET estoque = ? WHERE codigo = ?";

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		preparador.setInt(1, qnt);

		preparador.setInt(2, id);

		preparador.execute();

		preparador.close();

		System.out.println("Altera��o realizada!");

		} catch (SQLException e) {

		System.out.println("Erro - "+ e.getMessage());
		
	
}
	}
	
	public void deleteProduto(int id) {

		String sql = "DELETE FROM produto WHERE codigo = ?";

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		preparador.setInt(1, id);

		preparador.execute();

		preparador.close();

		System.out.println("Dele��o realizada!");

		} catch (SQLException e) {

		System.out.println("Erro - "+ e.getMessage());

		}
		}
	
	public List<Produto> selectprodutos(){

		String sql = "SELECT * FROM produto";

		List<Produto> lista = new ArrayList<Produto>();

		try {

		PreparedStatement preparador = con.prepareStatement(sql);

		ResultSet resultados = preparador.executeQuery();

		while (resultados.next()) {
			
			
			Produto prod2 = new Produto();

			prod2.setCodigo(resultados.getInt("codigo"));

			prod2.setNomeP(resultados.getString("nomeP"));

			prod2.setCategoria(resultados.getString("categoria"));
		
			prod2.setEstoque(resultados.getInt("estoque"));

			prod2.setPreco(resultados.getDouble("preco"));


			lista.add(prod2);

		} 

		} catch (SQLException e) {

		System.out.println("Erro - " + e.getMessage());

		}

		return lista; 

		} 
		
	

}
