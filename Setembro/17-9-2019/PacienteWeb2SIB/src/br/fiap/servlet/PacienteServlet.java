package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.PacienteDAO;
import br.fiap.modelo.Paciente;

@WebServlet("/adicionarpaciente")
@SuppressWarnings("serial")
public class PacienteServlet extends HttpServlet {

	public PacienteServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		PacienteDAO dao = new PacienteDAO();
		boolean sucesso = dao.cadastrar(new Paciente(cpf, nome, fone));
		if(sucesso) {
			request.setAttribute("nome", nome);
			System.out.println(nome);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mensagemSucesso.jsp");
			dispatcher.forward(request, response);
		}
	}

}
