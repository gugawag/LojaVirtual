package com.gugawag.amazon.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gugawag.amazon.modelo.Produto;

/**
 * Servlet implementation class ListaProdutosServlet
 */
@WebServlet("/listarprodutos.do")
public class ListaProdutosServlet_SUBSTITUIDO_POR_JSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProdutosServlet_SUBSTITUIDO_POR_JSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Produto> produtos = (List<Produto>)getServletContext().getAttribute("produtos");
		PrintWriter out = response.getWriter();
		out.write("<html><body><table border=1>");
		out.write("<tr><td><b>Descrição</b></td><td><b>Valor</b></td></tr>");
		for(Produto produto: produtos){
			out.write("<tr><td><a href=\"inserir.do?codigo=" + produto.getCodigo()+ "\">");
			out.write(produto.getDescricao());
			out.write("</a></td><td>");
			out.write("" + produto.getValor());
			out.write("</td></tr>");
		}
		out.write("</table></body></html>");
		out.close();
		
	}

}
