/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gugawag.loja.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gugawag.loja.modelo.Carrinho;
import com.gugawag.loja.modelo.Produto;

/**
 *
 * @author profgustavo
 */
@WebServlet("/inserirproduto.do")
public class InsereProdutoServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        int codigo = Integer.parseInt((String)request.getParameter("codigo"));

        List<Produto> produtos = (List<Produto>)getServletContext().getAttribute("produtos");
        Produto produtoAInserir = produtos.get(codigo-1);

        HttpSession secao = request.getSession(true);
        Carrinho carrinho = (Carrinho)secao.getAttribute("carrinho");
        if (carrinho == null){
            carrinho = new Carrinho();
            secao.setAttribute("carrinho", carrinho);
        }
        carrinho.insereProduto(produtoAInserir);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarcarrinho.do");
        dispatcher.forward(request, response);
    } 

}
