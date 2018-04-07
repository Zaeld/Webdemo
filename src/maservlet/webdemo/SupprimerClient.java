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
 * Servlet implementation class SupprimerClient
 */
@WebServlet("/SupprimerClient")
public class SupprimerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerClient() {
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
		
			RequestDispatcher dispatcher;
		
	if (clientService.deleteClient(dao, client))
			dispatcher = request.getRequestDispatcher("OperationWorks.html");
		else 
			dispatcher = request.getRequestDispatcher("OperationFail.html");
		
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
