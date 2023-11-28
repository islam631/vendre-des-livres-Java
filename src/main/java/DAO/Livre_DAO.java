package DAO;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.MBeanServerFactory;

import Beans.Admin;
import Beans.Livre;
import Beans.TimsTamp_Beans;

public class Livre_DAO {
	private final static String N_BDD = Class_Connection.getNome_dataBase();

	public static void create_Livre(String TITRE_LV, int PRIX_LV, String DESC_LV, int NMRPAGE_LV, String DATEPR_LV,
			int ID_CT, String IMAGE) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"INSERT INTO " + N_BDD + ".LIVRE VALUES(?,?,?,?,?," + (String) DATEPR_LV + ",?,?)");) {
			statmnt.setInt(1, (int) (get_max_id_Livre_S() + 1));
			statmnt.setString(2, TITRE_LV);
			statmnt.setInt(3, PRIX_LV);
			statmnt.setString(4, DESC_LV);
			statmnt.setInt(5, NMRPAGE_LV);
			statmnt.setInt(6, ID_CT);
			statmnt.setString(7, IMAGE);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int Get_ID_Livre(String TITRE_LV) {
		int i = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"SELECT A.ISBN_LV FROM " + (String) N_BDD + ".Livre A WHERE A.TITRE_LV=? ");) {

			statmnt.setString(1, TITRE_LV);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				i = r.getInt("ISBN_LV");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}

	public static void update_Livre(String titre_livre_vieille, String TITRE_LV, double PRIX_LV, String DESC_LV,
			int NMRPAGE_LV, int[] DATEPR_LV, String statut_temporel, int ID_CT) {

		String date_PRlivre = (String) new TimsTamp_Beans((int) DATEPR_LV[0], (int) DATEPR_LV[1], (int) DATEPR_LV[2],
				(int) DATEPR_LV[3], (int) DATEPR_LV[4], (int) DATEPR_LV[5]).Timstamp_sintax_sql(statut_temporel);
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn
						.prepareStatement("UPDATE " + (String) N_BDD + ".Livre A SET A.TITRE_LV=?,"
								+ " A.PRIX_LV=?,A.DESC_LV=?,A.NMRPAGE_LV=?,A.DATEPR_LV=" + (String) date_PRlivre + " ,"
								+ "A.ID_CT=? WHERE A.ISBN_LV=" + (int) Get_ID_Livre(titre_livre_vieille));) {

			statmnt.setString(1, TITRE_LV);
			statmnt.setDouble(2, PRIX_LV);
			statmnt.setString(3, DESC_LV);
			statmnt.setInt(4, NMRPAGE_LV);
			statmnt.setInt(5, ID_CT);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Livre reaserch_Livre(String TITRE_LV) {
		Livre Livre_lv = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT A.* FROM " + (String) N_BDD
						+ ".Livre A WHERE A.ISBN_LV=" + (int) Get_ID_Livre(TITRE_LV));) {
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				Livre_lv = new Livre(r.getInt("ISBN_LV"), r.getString("TITRE_LV"), r.getInt("PRIX_LV"),
						r.getString("DESC_LV"), r.getInt("NMRPAGE_LV"), r.getString("DATEPR_LV"), r.getInt("ID_CT"),
						r.getString("IMAGE"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

		return Livre_lv;
		
	}

	public static void delete_Livre_S() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn.prepareStatement("DELETE " + N_BDD + ".Livre");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int get_max_id_Livre_S() {
		int ISBN_LV = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.ISBN_LV) AS MAX_ID FROM " + N_BDD + ".Livre A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				ISBN_LV = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ISBN_LV;
	}

	public static int delete_and_Order_ISBN_LV_asc(int id) {
		int row = 0;
		int max_id = get_max_id_Livre_S();
		try {

			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_BDD + ".Livre A WHERE A.ISBN_LV=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, id);
			p1.execute();
			for (int i = id; i < max_id; i++) {
				p2 = conn.prepareStatement(
						"UPDATE " + N_BDD + ".Livre A SET A.ISBN_LV=" + (int) i + " WHERE A.ISBN_LV=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}

	public static ArrayList<Livre> GetLivrs() {
		Livre l = new Livre();

		ArrayList<Livre> livre = new ArrayList<>();
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn
						.prepareStatement("SELECT L.ISBN_LV , L.TITRE_LV , L.NMRPAGE_LV,L.IMAGE ,L.PRIX_LV FROM "
								+ N_BDD + ".Livre L ORDER BY L.ISBN_LV ASC");) {
			ResultSet r = p.executeQuery();

			while (r.next()) {

				livre.add(new Livre(r.getInt("ISBN_LV"), r.getString("TITRE_LV"), r.getDouble("PRIX_LV"), null,
						r.getInt("NMRPAGE_LV"), null, 0, r.getString("IMAGE")));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return livre;
	}

	public static Livre getLivreid(int id) {
		Livre livre = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement("SELECT * FROM " + N_BDD + ".Livre where ISBN_LV=?");) {
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				livre = new Livre(r.getInt("ISBN_LV"), r.getString("TITRE_LV"), r.getInt("PRIX_LV"),
						r.getString("DESC_LV"), r.getInt("NMRPAGE_LV"), r.getString("DATEPR_LV"), r.getInt("ID_CT"),
						r.getString("IMAGE"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return livre;
	}

}
