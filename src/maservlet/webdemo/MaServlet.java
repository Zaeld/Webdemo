package maservlet.webdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dAO.ClientDAO;
import domaine.Client;
import service.ClientService;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaServlet() {
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

		String nom =request.getParameter("nom");
		String prenom=request.getParameter("prenom");	
		
		Client client = new Client(nom, prenom);
		
		RequestDispatcher dispatcher;
	boolean a=clientService.creerClient(dao, client);
	if (nom==null || prenom=="" || nom=="")
		a=false;
		if(a) {
			dispatcher = request.getRequestDispatcher("felicitation.html");
		}else {
			dispatcher=request.getRequestDispatcher("deception.html");
		}
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
