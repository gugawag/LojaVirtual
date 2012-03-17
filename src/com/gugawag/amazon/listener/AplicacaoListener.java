package com.gugawag.amazon.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.gugawag.amazon.modelo.Produto;

@WebListener
public class AplicacaoListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto(1, "Livro: O Restaurante no Fim do Universo", 10));
		produtos.add(new Produto(2, "Rel—gio Mido", 10000));
		produtos.add(new Produto(3, "Nike Vomero 6", 600));
		produtos.add(new Produto(4, "Livro: O Poderoso Chef‹o", 70));
		event.getServletContext().setAttribute("produtos", produtos);
		
	}

}
