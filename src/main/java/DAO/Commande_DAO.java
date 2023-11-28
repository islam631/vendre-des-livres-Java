package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Beans.Commande;
import Beans.CompteCL;
import Beans.TimsTamp_Beans;

public class Commande_DAO {
	private final static String N_BDD = Class_Connection.getNome_dataBase();

	// create [x]
	// reaserch [x]
	// update [x]
	// delete [x]
	public static void create_Commande_DAO(int ID_CMP, int ID_VILLE) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("INSERT INTO " + (String) N_BDD + ".commande VALUES("
						+ (String) N_BDD + ".NEMURO_CMP.NEXTVAL,SYSDATE,?,?)");) {

			statmnt.setInt(1, ID_CMP);
			statmnt.setInt(2, ID_VILLE);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static int Get_id_Commande(String DATE_CMP, int ID_CMP) {
		int id = 0;
		try (// 23-DEC-22 02.03.29.000000 PM || "Taha.Elamine"
				Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement("SELECT C.NEMURO_CMP FROM " + N_BDD
						+ ".Commande C WHERE C.DATE_CMP=" + DATE_CMP + " AND C.ID_CMP=?");) {
			p.setInt(1, ID_CMP);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				id = r.getInt("NEMURO_CMP");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	public static Commande reaserch_Commande(String DATE_CMP, int ID_CMP) {
		Commande commande = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn
						.prepareStatement("SELECT C.* FROM " + N_BDD + ".Commande C where C.NEMURO_CMP=?");) {
			p.setInt(1, (int) Get_id_Commande(DATE_CMP, ID_CMP));
			ResultSet r = p.executeQuery();
			while (r.next()) {
				commande = new Commande(r.getInt("NEMURO_CMP"), r.getString("DATE_CMP"), r.getInt("ID_CMP"),
						r.getInt("ID_VILLE"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return commande;
	}

	public static int update_Commande(int NEMURO_CMP, int ID_CMP, int ID_VILLE) {
		int i = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement(
						"UPDATE " + (String) N_BDD + ".Commande C SET C.ID_CMP=?,C.ID_VILLE=? WHERE C.NEMURO_CMP=?");) {
			p.setInt(1, ID_CMP);
			p.setInt(2, ID_VILLE);
			p.setInt(3, NEMURO_CMP);
			i = p.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}

	public static void delete_Commande(String DATE_CMP, int ID_CMP) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement("delete " + N_BDD + ".Commande C WHERE C.NEMURO_CMP=?");) {
			p.setInt(1, (int) Get_id_Commande(DATE_CMP, ID_CMP));
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// int annee, int month, int day, int hour, int min, int seq
		String a = (String) new TimsTamp_Beans(2022, 12, 23, 2, 3, 29).Timstamp_sintax_sql("PM");
		// System.out.println(a);
		// System.out.println(Get_id_Commande(a,CompteCL_DAO.GetId_CompteCL("Taha.Elamine")));

		// System.out.println(update_Commande(2, 1, 2));
		delete_Commande(a, (int) CompteCL_DAO.GetId_CompteCL("Taha.Elamine"));
		System.out.println("oki");
	}

}
