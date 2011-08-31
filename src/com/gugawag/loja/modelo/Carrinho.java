/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gugawag.loja.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author profgustavo
 */
public class Carrinho {
    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<Produto>();
    }


    public void insereProduto(Produto produto){
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }




}
