package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Auteur;
import Beans.TimsTamp_Beans;

public class Auteur_DAO {

	private final static String N_BDD = Class_Connection.getNome_dataBase();

	public static void create_Auteur(String NOM_AUT, String PRENOM_AUT, String DATEN_AUT, String NATIONALITE_AUT) {

		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"INSERT INTO " + (String) N_BDD + ".Auteur(ID_AUT,NOM_AUT,PRENOM_AUT,DATEN_AUT,NATIONALITE_AUT)"
								+ "VALUES(?,?,?," + DATEN_AUT + ",?)");) {
			statmnt.setInt(1, (int)(get_max_idAuteur()+1));
			statmnt.setString(2, NOM_AUT);
			statmnt.setString(3, PRENOM_AUT);
			// statmnt.setString(3, DATEN_AUT);
			statmnt.setString(4, NATIONALITE_AUT);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int GetIdAuteur(String NOM_AUT, String PRENOM_AUT) {
		int i = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"SELECT A.ID_AUT FROM " + (String) N_BDD + ".Auteur A WHERE A.NOM_AUT=? AND A.PRENOM_AUT=?");) {
			statmnt.setString(1, NOM_AUT);
			statmnt.setString(2, PRENOM_AUT);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				i = r.getInt("ID_AUT");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}

	

	public static void update_Auteur(String NOM_AUT, String PRENOM_AUT, String DATEN_AUT, String NATIONALITE_AUT,
			int ID_AUT) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"UPDATE " + (String) N_BDD + ".Auteur A SET A.NOM_AUT=?," + "A.PRENOM_AUT=?,A.DATEN_AUT="
								+ DATEN_AUT + ",A.NATIONALITE_AUT=? WHERE A.ID_AUT=?");) {
			statmnt.setString(1, NOM_AUT);
			statmnt.setString(2, PRENOM_AUT);
			statmnt.setString(3, NATIONALITE_AUT);
			statmnt.setInt(4, ID_AUT);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Auteur reaserch_Auteur(String NOM_AUT, String PRENOM_AUT) {
		Auteur auteur = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT A.* FROM " + (String) N_BDD
						+ ".Auteur A WHERE A.ID_AUT=" + GetIdAuteur(NOM_AUT, PRENOM_AUT));) {
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				auteur = new Auteur(r.getInt("ID_AUT"), r.getString("NOM_AUT"), r.getString("PRENOM_AUT"),
						r.getString("DATEN_AUT"), r.getString("NATIONALITE_AUT"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return auteur;
	}
	
	/*public static void main(String[] args) {
		System.out.println(reaserch_Auteur("Taha8", "chena").getDATEN_AUT());
	}*/
	
	public static void delete_Auteurs() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("DELETE " + N_BDD + ".Auteur");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int get_max_idAuteur() {
		int ID_AUT = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.ID_AUT) AS MAX_ID FROM " + N_BDD + ".Auteur A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				ID_AUT = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ID_AUT;
	}
	
	public static int delete_and_Order_ID_AUT_asc(int id) {
		int row = 0;
		int max_id = get_max_idAuteur();
		try {
			// ----<
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_BDD + ".Auteur A WHERE A.ID_AUT=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, id);
			p1.execute();
			for (int i = id; i < max_id; i++) {
				p2 = conn.prepareStatement("UPDATE " + N_BDD + ".Auteur A SET A.ID_AUT=" + (int) i
						+ " WHERE A.ID_AUT=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}
}
