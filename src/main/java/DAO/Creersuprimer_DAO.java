package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.CompteCL;

public class Creersuprimer_DAO {
	private final static String N_BDD = Class_Connection.getNome_dataBase();
	public static void create_Creersuprimer(int ID_CMP, int ID_ADMIN) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn
						.prepareStatement("INSERT INTO " + (String) N_BDD + ".creersuprimer VALUES(?,?)");) {
			statmnt.setInt(1, ID_CMP);
			statmnt.setInt(2, ID_ADMIN);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void delete_Creersuprimer(int ID_CMP, int ID_ADMIN) {

		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn
						.prepareStatement("DELETE " + N_BDD + ".Creersuprimer C WHERE C.ID_CMP=? AND C.ID_ADMIN=?");) {
			statmnt.setInt(1, ID_CMP);
			statmnt.setInt(2, ID_ADMIN);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static Beans.Creersuprimer reaserch_Creersuprimer(int ID_CMP, int ID_ADMIN) {
		Beans.Creersuprimer creersuprimer = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"SELECT C.* FROM " + (String) N_BDD + ".creersuprimer C WHERE C.ID_CMP=? AND C.ID_ADMIN=?");) {
			statmnt.setInt(1, ID_CMP);
			statmnt.setInt(2, ID_ADMIN);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				creersuprimer = new Beans.Creersuprimer(r.getInt("ID_CMP"), r.getInt("ID_ADMIN"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return creersuprimer;
	}
}
