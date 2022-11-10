package br.com.padaria.model;

public class Funcionario {
	
	
	private int matricula;

	private String nome;

	private String endereco;

	private String sexo;
	
	private String cargo;

	private double salario;
	
	
	public Funcionario() {
		super();
	}

	public Funcionario(int matricula, String nome, String endereco, String sexo, String cargo, double salario) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.cargo = cargo;
		this.salario = salario;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	

}
