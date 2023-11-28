package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Ajouter;
import Beans.Contient;

public class Contient_DAO {
	private final static String N_BDD = Class_Connection.getNome_dataBase();

	public static void create_Contient(int NEMURO_CMP, int ISBN_LV, int QUATITE_CNT) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("INSERT INTO " + (String) N_BDD
						+ ".Contient(NEMURO_CMP,ISBN_LV,QUATITE_CNT)" + "VALUES(?,?,?)");) {
			statmnt.setInt(1, NEMURO_CMP);
			statmnt.setInt(2, ISBN_LV);
			statmnt.setInt(3, QUATITE_CNT);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void delete_Contient(int NEMURO_CMP, int ISBN_LV, int QUATITE_CNT) {

		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"DELETE " + N_BDD + ".Contient C WHERE C.NEMURO_CMP=? AND C.ISBN_LV=? AND C.QUATITE_CNT=?");) {
			statmnt.setInt(1, NEMURO_CMP);
			statmnt.setInt(2, ISBN_LV);
			statmnt.setInt(3, QUATITE_CNT);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void update_Contient(int NEMURO_CMP, int ISBN_LV, int QUATITE_CNT) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("UPDATE " + (String) N_BDD
						+ ".Contient C SET C.QUATITE_CNT=? WHERE C.NEMURO_CMP=? AND C.ISBN_LV=?");) {
			statmnt.setInt(1, QUATITE_CNT);
			statmnt.setInt(2, NEMURO_CMP);
			statmnt.setInt(3, ISBN_LV);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Beans.Contient reaserch_Contient(int NEMURO_CMP, int ISBN_LV, int QUATITE_CNT) {
		Beans.Contient contient = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT C.* FROM " + (String) N_BDD
						+ ".Contient C WHERE C.NEMURO_CMP=? AND C.ISBN_LV=? AND C.QUATITE_CNT=?");) {
			statmnt.setInt(1, NEMURO_CMP);
			statmnt.setInt(2, ISBN_LV);
			statmnt.setInt(3, QUATITE_CNT);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				contient = new Contient(r.getInt("NEMURO_CMP"), r.getInt("ISBN_LV"), r.getInt("QUATITE_CNT"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return contient;
	}

}
