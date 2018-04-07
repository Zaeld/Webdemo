package dAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Client;

public class ClientDAO {
	public Statement connexion() {
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd4", "root", "");
			stmt = maConnection.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	public boolean creerClient(Client client) {
		int i = 0;
		boolean b = false;
		Statement stmt = this.connexion();
		String s = "INSERT INTO `client`(`nom`, `prenom`, `age`, `idConseiller`) VALUES ('" + client.getNom() + "', '" + client.getPrenom() + "', '"
				+ client.getAge() + "', " + client.getIdConseiller()+ ")";
		try {
			i = stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i != 0)
			b = true;
		return b;

	}

	public Client getClient(int idClient, Client client) {
		try {
			Statement stmt = this.connexion();

			String s = "Select * from Client where idClient = " + idClient;
			// Etape 4 : exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			rs.next();
			client.setIdClient(rs.getInt("idClient"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setIdConseiller(rs.getInt("idConseiller"));
			client.setAge(rs.getInt("age"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;

	}

	public Client updateClient(Client client) {
		try {
			Statement stmt = this.connexion();

			String s = "UPDATE client set nom = '" + client.getNom() + "', prenom = '" + client.getPrenom()
					+ "', idConseiller = " + client.getIdConseiller() + ", age = " + client.getAge()
					+ " where idclient = " + client.getIdClient();
			stmt.executeUpdate(s);
			s = "Select * from Client where idClient = " + client.getIdClient();
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			rs.next();
			client.setIdClient(rs.getInt("idClient"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setIdConseiller(rs.getInt("idConseiller"));
			client.setAge(rs.getInt("age"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	public boolean deleteClient(Client client) {
		int i;
		boolean b = false;
		try {
			Statement stmt = this.connexion();

			String s = "DELETE from client where idClient = " + client.getIdClient();
			i = stmt.executeUpdate(s);
			if (i != 0)
				b = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public List<Client> getAll() {
		List<Client> listClient = new ArrayList<Client>();

		try {
			Statement stmt = this.connexion();

			String s = "Select * from Client";
			// Etape 4 : exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("idClient"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setIdConseiller(rs.getInt("idConseiller"));
				client.setAge(rs.getInt("age"));
				listClient.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}
}