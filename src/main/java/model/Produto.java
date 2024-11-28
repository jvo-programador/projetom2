package model;

import java.util.ArrayList;

public class Produto {
	private int idProduto;
	private String nomeproduto;
	private int qtdProduto;
	private float valorProduto;
	
	public  Produto () {}

	public Produto(int idProduto, String nomeProduto, int qtdProduto, float valorProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeproduto = nomeProduto;
		this.qtdProduto = qtdProduto;
		this.valorProduto = valorProduto;
	}

	public Produto(String nomeProduto, int qtdProduto, float valorProduto) {
		super();
		this.nomeproduto = nomeProduto;
		this.qtdProduto = qtdProduto;
		this.valorProduto = valorProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}

	
	
	
	
}
