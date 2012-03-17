package com.gugawag.amazon.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<ItemCarrinho> itens;

	
	public Carrinho() {
		itens = new ArrayList<ItemCarrinho>();
	}

	public void adicionaItem(ItemCarrinho item){
		itens.add(item);
	}
	
	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public double getValorTotal(){
		double valorTotal = 0;
		
		for(ItemCarrinho item: itens){
			valorTotal += item.getValor();
		}
		return valorTotal;
	}

}
