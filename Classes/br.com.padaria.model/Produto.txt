package br.com.padaria.model;

public class Produto {
		
	private int codigo;

	private String nomeP;
	
	private String categoria;

	private int estoque;

	private double preco;
	
	public Produto(int codigo, String nomeP, String categoria, int estoque, double preco) {
		super();
		this.codigo = codigo;
		this.nomeP = nomeP;
		this.categoria = categoria;
		this.estoque = estoque;
		this.preco = preco;
	}
	

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeP() {
		return nomeP;
	}

	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
