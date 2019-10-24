package br.fiap.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class ContatoServlet
 */
@WebServlet("/cadastro")
public class ContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//objeto para enviar um despacho
		RequestDispatcher dispatcher;
		
		//objeto para formatar a data
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		//obtém os dados da requisção
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataString = request.getParameter("data");
		String genero = request.getParameter("genero");
		
		try {
			Date data = new Date(formato.parse(dataString).getTime());
			Contato contato = new Contato(nome, email, endereco, data, genero);
			ContatoDAO dao = new ContatoDAO();
			dao.cadastrar(contato);
			List<Contato> lista = dao.listar();
			request.setAttribute("lista", lista);
			dispatcher = request.getRequestDispatcher("listagem.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
	}

}
