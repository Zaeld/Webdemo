package maservlet.webdemo;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ListeClients
 */
@WebServlet("/ListeClients")
public class ListeClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeClients() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Client client = new Client();
	ClientService service = new ClientService();
	List<Client> list = service.getAll();
//
//		for (Client client : list) {
//response.getWriter().println(client);
//		}


HttpSession maSession = request.getSession();
maSession.setAttribute("liste", list);

RequestDispatcher dispatcher = request.getRequestDispatcher("clients.jsp");
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
