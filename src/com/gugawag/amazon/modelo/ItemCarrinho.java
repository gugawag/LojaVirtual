package com.gugawag.amazon.modelo;

public class ItemCarrinho {
	
	private Produto produto;
	private int quant;
	
	
	public ItemCarrinho(Produto produto, int quant) {
		super();
		this.produto = produto;
		this.quant = quant;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public double getValor(){
		return quant * produto.getValor();
	}

}
