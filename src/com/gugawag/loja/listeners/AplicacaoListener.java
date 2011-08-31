package com.gugawag.loja.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.gugawag.loja.modelo.Produto;

@WebListener
public class AplicacaoListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto(1, "O poderoso chef‹o", 50));
		produtos.add(new Produto(2, "O poderoso chef‹o II", 51));
		produtos.add(new Produto(3, "O poderoso chef‹o III", 52));
		
		event.getServletContext().setAttribute("produtos", produtos);
		
	}

}
