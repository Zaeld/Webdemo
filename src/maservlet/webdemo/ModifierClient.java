package maservlet.webdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dAO.ClientDAO;
import domaine.Client;
import service.ClientService;

/**
 * Servlet implementation class ModifierClient
 */
@WebServlet("/ModifierClient")
public class ModifierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClientDAO dao = new ClientDAO();
		ClientService clientService = new ClientService();
		Client client = new Client();

		String a =request.getParameter("idClient");
		int idClient = Integer.parseInt(a); 
		
		client=clientService.getClient(dao, idClient, client);
		
		HttpSession maSession = request.getSession();
		maSession.setAttribute("client", client);
		RequestDispatcher dispatcher=request.getRequestDispatcher("client.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
