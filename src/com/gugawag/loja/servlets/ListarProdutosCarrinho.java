/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gugawag.loja.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gugawag.loja.modelo.Carrinho;
import com.gugawag.loja.modelo.Produto;

/**
 *
 * @author profgustavo
 */
@WebServlet("/listarcarrinho.do")
public class ListarProdutosCarrinho extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");

        List<Produto> produtos = carrinho.getProdutos();
        
        PrintWriter saida = response.getWriter();
        saida.write("<html><body>");
        saida.write("<table border=1>");
        saida.write("<tr><td>Código</td><td>Descrição</td><td>Valor</td></tr>");
        for(Produto produto: produtos){
            saida.write("<tr><td>");
            saida.write("" + produto.getCodigo());
            saida.write("</td>");
            saida.write("<td>");
            saida.write(produto.getDescricao());
            saida.write("</td><td>");
            saida.write("" + produto.getValor());
            saida.write("</td></tr>");
        }
        saida.write("</body>");
        saida.write("</html>");
        saida.flush();
        saida.close();

    }

   
}
