package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Ajouter;
import Beans.VillCl_Beans;

public class Ajouter_DAO {

	private final static String N_BDD = Class_Connection.getNome_dataBase();

	public static void create_Ajouter(int ID_ADMIN, int ISBN_LV, int NBREMPR_LV) {

		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"INSERT INTO " + (String) N_BDD + ".Ajouter(ID_ADMIN,ISBN_LV,NBREMPR_LV)" + "VALUES(?,?,?)");) {
			statmnt.setInt(1, ID_ADMIN);
			statmnt.setInt(2, ISBN_LV);
			statmnt.setInt(3, NBREMPR_LV);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void delete_Ajouter(int ID_ADMIN, int ISBN_LV, int NBREMPR_LV) {

		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"DELETE " + N_BDD + ".Ajouter A WHERE A.ID_ADMIN=? AND A.ISBN_LV=? AND A.NBREMPR_LV=?");) {
			statmnt.setInt(1, ID_ADMIN);
			statmnt.setInt(2, ISBN_LV);
			statmnt.setInt(3, NBREMPR_LV);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void update_Ajouter(int ID_ADMIN, int ISBN_LV, int NBREMPR_LV) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("UPDATE " + (String) N_BDD
						+ ".Ajouter A SET A.NBREMPR_LV=? WHERE A.ID_ADMIN=? AND A.ISBN_LV=?");) {
			statmnt.setInt(1, NBREMPR_LV);
			statmnt.setInt(2, ID_ADMIN);
			statmnt.setInt(3, ISBN_LV);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Ajouter reaserch_VillCl(int ID_ADMIN, int ISBN_LV, int NBREMPR_LV) {
		Ajouter ajouter = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT A.* FROM " + (String) N_BDD
						+ ".Ajouter A WHERE A.ID_ADMIN=? AND A.ISBN_LV=? AND A.NBREMPR_LV=?");) {
			statmnt.setInt(1, ID_ADMIN);
			statmnt.setInt(2, ISBN_LV);
			statmnt.setInt(3, NBREMPR_LV);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				ajouter = new Ajouter(r.getInt("ID_ADMIN"), r.getInt("ISBN_LV"), r.getInt("NBREMPR_LV"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return ajouter;
	}
	
}
