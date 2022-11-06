package br.com.padaria.model;

import java.sql.Date;

public class Venda {
	
	
	private int codigoV;

	private int prod;

	private int vendedor;

	private int quantidade;
		
	private Date dataV;
	
	

	public Venda() {
		super();
	}

	public Venda(int codigoV, int prod, int vendedor, int quantidade, Date dataV) {
		super();
		this.codigoV = codigoV;
		this.prod = prod;
		this.vendedor = vendedor;
		this.quantidade = quantidade;
		this.dataV = dataV;
	}

	public int getCodigoV() {
		return codigoV;
	}

	public void setCodigoV(int codigoV) {
		this.codigoV = codigoV;
	}

	public int getProd() {
		return prod;
	}

	public void setProd(int prod) {
		this.prod = prod;
	}

	public int getVendedor() {
		return vendedor;
	}

	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataV() {
		return dataV;
	}

	public void setDataV(Date dataV) {
		this.dataV = dataV;
	}

	
	
	
}
