package com.gugawag.amazon.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gugawag.amazon.modelo.Carrinho;
import com.gugawag.amazon.modelo.ItemCarrinho;

/**
 * Servlet implementation class ListaProdutosServlet
 */
@WebServlet("/listarcarrinho.do")
public class ListaCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCarrinhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Carrinho carrinho = (Carrinho)sessao.getAttribute("carrinho");
		
		List<ItemCarrinho> itens = carrinho.getItens(); 
		PrintWriter out = response.getWriter();
		out.write("<html><body><table border=1>");
		out.write("<tr><td><b>DescriÁ„ção</b></td><td><b>Valor Unitá·rio</b></td><td><b>Quantidade</b></td></tr>");
		for(ItemCarrinho item: itens){
			out.write("<tr><td>");
			out.write(item.getProduto().getDescricao());
			out.write("</td><td>");
			out.write("" + item.getProduto().getValor());
			out.write("</td></tr>");
		}
		out.write("<tr><td><b>Valor Total:</b></td><td>COLOCAR AQUI</td></tr>");
		out.write("</table> <a href=\"listarProdutos.jsp\">Continuar Comprando</a>|" +
				"<a href=\"finalizar.do\">Finalizar Compra</a>" +
				"</body></html>");
		out.close();
		
	}

}
