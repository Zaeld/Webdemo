package service;



import java.util.List;

import dAO.ClientDAO;
import domaine.Client;

public class ClientService {
	public boolean creerClient(ClientDAO dao, Client client) {
		return (dao.creerClient(client));
		
	}

	public Client getClient(ClientDAO dao, int idClient, Client client) {
		System.out.println("R�cup�ration du client dans la base de donn�e");
		return dao.getClient(idClient, client);
	}

	public Client updateClient(ClientDAO dao, Client client) {
		System.out.println("Modification des donn�es du client");

		return dao.updateClient(client);
	}

	public String deleteClient(ClientDAO dao, Client client) {
		if (dao.deleteClient(client))
			return "Le client a �t� supprim� avec succ�s";
		else
			return "Le client ne peut pas �tre supprim�";
	}

	public List getAll() {
		ClientDAO dao = new ClientDAO();
		List<Client> list = dao.getAll();
	return list;
		}
	}

// domaine.Client client = new Client();
//
// Scanner c = new Scanner(System.in);
// Scanner i = new Scanner(System.in);
//
// System.out.println("Veuillez rentrer le nom du client :");
// client.setNom(c.nextLine());
// System.out.println("Veuillez rentrer le prenom du client :");
// client.setPrenom(c.nextLine());
// System.out.println("Veuillez rentrer l'idConseiller du client :");
// client.setIdConseiller(i.nextInt());
// System.out.println("Veuillez rentrer l'age du client :");
// client.setAge(i.nextInt());
//
