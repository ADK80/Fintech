package br.com.fiap.fintech.bean;

import java.util.Calendar;

public class Conta {

	private int codigo;
	
	private double valor;
	
	private Calendar dataDeposito;
	
	private Categoria categoria;
	
	public Conta() {
		super();
	}

	public Conta(int codigo, double valor, Calendar dataDeposito) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.dataDeposito = dataDeposito;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Calendar dataDeposito) {
		this.dataDeposito = dataDeposito;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}