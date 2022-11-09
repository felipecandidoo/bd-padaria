package br.com.padaria;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import br.com.padaria.DAO.FuncionarioDAO;
import br.com.padaria.DAO.ProdutoDAO;
import br.com.padaria.DAO.VendaDAO;
import br.com.padaria.model.Funcionario;
import br.com.padaria.model.Produto;
import br.com.padaria.model.Venda;

public class Principal {

	public static void main(String[] args) throws Exception, SQLException {
		
		System.out.println("+------------------------------------------------------+");
		System.out.println("|               PADARIA BDII                           |");
		System.out.println("+------------------------------------------------------+");

		while (true) {
			
			
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 1. Cadastrar Produto                                 |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 2. Listar Produto                                    |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 3. Atualizar estoque de produto                      |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 4. Deletar produto                                   |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 5. Cadastar Funcionario                              |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 6. Listar Funcionarios                               |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 7. Alterar salario de Funcionario                    |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 8. Retirar cadastro de um funcionario                |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 9. Cadastrar Venda                                   |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 10. Alterar valor da venda                           |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 11. Listar vendas                                    |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 12. Deletar venda                                    |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 13. Sair                                             |");
			System.out.println("+------------------------------------------------------+");
		
			System.out.print("Digite a sua opção: ");
			int opcao = Teclado.leInt();

			ProdutoDAO prodDAO = new ProdutoDAO();
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			VendaDAO vendaDAO = new VendaDAO();
			

// ********************************** PRODUTO **** *********************************
			if (opcao == 1) {

				System.out.print("Digite o codigo: ");
				int codigo = Teclado.leInt();
				System.out.print("Digite o nome: ");
				String nome = Teclado.leString();
				System.out.print("Digite a categoria: ");
				String categoria = Teclado.leString();
				System.out.print("Digite a quantidade em estoque: ");
				int qtdEstoque = Teclado.leInt();
				System.out.print("Digite o pre�o: ");
				double preco = Teclado.leDouble();

				Produto prod = new Produto(codigo, nome, categoria, qtdEstoque, preco);

				prodDAO.cadastrarProduto(prod);

			} else if (opcao == 2) {
				System.out.println("+---------------------------------------------------------------------------------------------+");
				System.out.println("| ID                    NOME                 CATEGORIA                ESTOQUE          PREÇO  |");
				System.out.println("+---------------------------------------------------------------------------------------------+");
				
				for (Produto prod : prodDAO.selectprodutos()) {
					System.out.printf("| %-21d%-21s%-28s%-13d%.2f |", prod.getCodigo(), prod.getNomeP(), prod.getCategoria(), prod.getEstoque(), prod.getPreco());
					System.out.println();
				}
				System.out.println("+---------------------------------------------------------------------------------------------+");


//				for (Produto prod : prodDAO.selectprodutos()) {
//					System.out.println("CODIGO: " + prod.getCodigo() + " | NOME: " + prod.getNomeP() + ""
//							+ " | CATEGORIA: " + prod.getCategoria() + " | ESTOQUE: " + prod.getEstoque() + " "
//							+ " | PREÇO: " + prod.getPreco());
//				}

			} else if (opcao == 3) {

				System.out.print("Digite o codigo do produto que deseja atualizar: ");
				int cod = Teclado.leInt();
				System.out.print("Digite a nova  quantidade em estoque: ");
				int qtd = Teclado.leInt();

				prodDAO.updateProduto(cod, qtd);

			} else if (opcao == 4) {

				System.out.print("Digite o codigo do produto que deseja deletar: ");
				int cod = Teclado.leInt();

				prodDAO.deleteProduto(cod);

			}

// ********************************** FUNCIONARIO ***************************************
			else if (opcao == 5) {

				System.out.print("Digite a matricula: ");
				int matric = Teclado.leInt();
				System.out.print("Digite o nome: ");
				String nome = Teclado.leString();
				System.out.print("Digite o endereco: ");
				String end = Teclado.leString();
				System.out.print("Digite o sexo (M/F): ");
				String sexo = Teclado.leString();
				System.out.print("Digite o cargo do funcionário: ");
				String cargo = Teclado.leString();
				System.out.print("Digite o salário: ");
				double salario = Teclado.leDouble();

				Funcionario func = new Funcionario(matric, nome, end, sexo, cargo, salario);

				funcDAO.cadastrarFuncionario(func);

			} else if (opcao == 6) {

				for (Funcionario func : funcDAO.selectTodos()) {
					System.out.println("MATRICULA: " + func.getMatricula() + " | NOME: " + func.getNome() + ""
							+ " | ENDERECO: " + func.getEndereco() + " | SEXO: " + func.getSexo() + " " + " | CARGO: "
							+ func.getCargo() + " | SALARIO: " + func.getSalario());
				}

			} else if (opcao == 7) {

				System.out.print("Digite a matricula do funcionario que deseja alterar o salario: ");
				int mat = Teclado.leInt();
				System.out.print("Digite o novo salario: ");
				double novosal = Teclado.leDouble();

				funcDAO.updateFuncionario(mat, novosal);

			} else if (opcao == 8) {

				System.out.print("Digite a matricula do funcionario que deseja deletar: ");
				int mat = Teclado.leInt();

				funcDAO.deleteFuncionario(mat);

			}
// ********************************** VENDAS ***************************************
			else if (opcao == 9) {

//				for (Produto prod : prodDAO.selectprodutos()) {
//					System.out.println("CODIGO: " + prod.getCodigo() + " | NOME: " + prod.getNomeP() + ""
//							+ " | CATEGORIA: " + prod.getCategoria() + " | ESTOQUE: " + prod.getEstoque() + " "
//							+ " | PREÇO: " + prod.getPreco());
//				}
//
				System.out.print("Digite o codigo do produto que deseja comprar: ");
				int cod = Teclado.leInt();
				System.out.print("Digite a quantidade que deseja comprar: ");
				int qtd = Teclado.leInt();
				
				Date data = new Date(System.currentTimeMillis());
				
				Random gerador = new Random();
				
				Venda venda = new Venda(gerador.nextInt(), cod, 2345, qtd, data);
				
				vendaDAO.cadastrarVenda(venda);

//??????????????????????????
			} else if (opcao == 10) {
				// alterar venda??
			} else if (opcao == 11) {
				for (Venda venda : vendaDAO.selectVendas()) {
					System.out.println("CODIGO: " + venda.getCodigoV() + " | PRODUTO: " + venda.getProd() + ""
							+ " | VENDEDOR: " + venda.getVendedor() + " | QUANTIDADE: " + venda.getQuantidade() + " "
							+ " | TOTAL: " + venda.getProd() * venda.getQuantidade() + " | DATA:" + venda.getDataV());
				}
			}
		}
	}
}
