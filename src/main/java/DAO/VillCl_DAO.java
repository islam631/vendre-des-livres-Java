package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Beans.Admin;
import Beans.VillCl_Beans;

public class VillCl_DAO {

	private final static String N_BDD = Class_Connection.getNome_dataBase();

	public static void create_VillCl(String PAYS_VL, String NOM_VL) {

		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn
						.prepareStatement("INSERT INTO " + (String) N_BDD + ".VillCl(ID_VILLE,PAYS_VL,NOM_VL)"
								+ "VALUES(?,?,?)");) {
			statmnt.setInt(1, (int)(get_max_id_VillCl_S()+1));
			statmnt.setString(2, PAYS_VL);
			statmnt.setString(3, NOM_VL);

			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("error create_VillCl");
		}

	}

	public static int GetId_VillCl(String PAYS_VL, String NOM_VL) {
		int i = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"SELECT V.ID_VILLE FROM " + (String) N_BDD + ".VillCl V WHERE V.PAYS_VL=? AND V.NOM_VL=?");) {
			statmnt.setString(1, PAYS_VL);
			statmnt.setString(2, NOM_VL);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				i = r.getInt("ID_VILLE");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}

	

	public static void update_VillCl(int id, String PAYS_VL, String NOM_VL) {
		try (// "+(String)N_BDD+"
				Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"UPDATE " + (String) N_BDD + ".VillCl V SET V.PAYS_VL=?," + "V.NOM_VL=? WHERE V.ID_VILLE=?");) {
			// administrateur
			statmnt.setString(1, PAYS_VL);
			statmnt.setString(2, NOM_VL);
			statmnt.setInt(3, id);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static VillCl_Beans reaserch_VillCl(String PAYS_VL, String NOM_VL) {
		VillCl_Beans ville = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT V.* FROM " + (String) N_BDD
						+ ".VillCl V WHERE V.ID_VILLE=" + GetId_VillCl(PAYS_VL, NOM_VL));) {
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				ville = new VillCl_Beans(r.getInt("ID_VILLE"), r.getString("PAYS_VL"), r.getString("NOM_VL"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return ville;
	}
	public static void delete_VillCl_S() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("DELETE " + N_BDD + ".VillCl");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int get_max_id_VillCl_S() {
		int ID_VILLE = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.ID_VILLE) AS MAX_ID FROM " + N_BDD + ".VillCl A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				ID_VILLE = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ID_VILLE;
	}
	
	public static int delete_and_Order_ID_VILLE_asc(int id) {
		int row = 0;
		int max_id = get_max_id_VillCl_S();
		try {
			// ----<
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_BDD + ".VillCl A WHERE A.ID_VILLE=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, id);
			p1.execute();
			for (int i = id; i < max_id; i++) {
				p2 = conn.prepareStatement("UPDATE " + N_BDD + ".VillCl A SET A.ID_VILLE=" + (int) i
						+ " WHERE A.ID_VILLE=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}
	
}
