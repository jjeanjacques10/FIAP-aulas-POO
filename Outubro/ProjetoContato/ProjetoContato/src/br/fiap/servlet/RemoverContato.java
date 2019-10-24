package br.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ContatoDAO;
import br.fiap.entidade.Contato;

/**
 * Servlet implementation class RemoverContato
 */
@WebServlet("/remover")
public class RemoverContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//objeto para enviar um despacho
	RequestDispatcher dispatcher;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		ContatoDAO dao = new ContatoDAO();
		dao.deletar(email);
		
		List<Contato> lista = dao.listar();
		request.setAttribute("lista", lista);
		dispatcher = request.getRequestDispatcher("listagem.jsp");
		dispatcher.forward(request, response);
	}

}
