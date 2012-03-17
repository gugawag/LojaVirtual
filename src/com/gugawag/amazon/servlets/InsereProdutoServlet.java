package com.gugawag.amazon.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gugawag.amazon.modelo.Carrinho;
import com.gugawag.amazon.modelo.ItemCarrinho;
import com.gugawag.amazon.modelo.Produto;

/**
 * Servlet implementation class InsereProdutoServlet
 */
@WebServlet("/inserir.do")
public class InsereProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsereProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		List<Produto> produtos = (List<Produto>)
				getServletContext().getAttribute("produtos");
		
		Produto produtoEscolhido = null;
		for (Produto produto: produtos){
			if (produto.getCodigo()==codigo){
				produtoEscolhido = produto;
				break;
			}
		}
		
		HttpSession sessao = request.getSession(true);
		Carrinho carrinho = (Carrinho)sessao.getAttribute("carrinho");
		if (carrinho == null){
			carrinho = new Carrinho();
			sessao.setAttribute("carrinho", carrinho);
		}
		carrinho.adicionaItem(new ItemCarrinho(produtoEscolhido, 1));
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarcarrinho.do");
		dispatcher.forward(request, response);
	}

}
