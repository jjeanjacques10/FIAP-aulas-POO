package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HospedagemServlet
 */
@WebServlet({ "/HospedagemServlet", "/" })
public class HospedagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospedagemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher;
		double numeroNoites, valor = 0;
		
		try {
			numeroNoites = Double.parseDouble(request.getParameter("numeroNoites"));
			
		}catch (Exception e) {
			 numeroNoites = 1;
		}
		
		while(numeroNoites != 0) {
			valor += 250 / numeroNoites;
			numeroNoites--;
		}
		
		request.setAttribute("valor", valor);
		
		dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	

}
