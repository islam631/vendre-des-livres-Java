package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Categorielv;
import Beans.CompteCL;

public class Categorielv_DAO {

	private final static String N_BDD = Class_Connection.getNome_dataBase();

	// create [x]
	// reaserch [x]
	// update [x]
	// delete [x]
	public static void create_Categorielv(String NOM_CT, String DESC_CT) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("INSERT INTO " + (String) N_BDD
						+ ".Categorielv VALUES(?,?,?)");) {
			statmnt.setInt(1, (int)(get_max_id_Categorielv_S()+1));
			statmnt.setString(2, NOM_CT);
			statmnt.setString(3, DESC_CT);

			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static int GetId_Categorielv(String NOM_CT) {
		int i = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"SELECT C.ID_CT FROM " + (String) N_BDD + ".Categorielv C WHERE C.NOM_CT=?");) {
			statmnt.setString(1, NOM_CT);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				i = r.getInt("ID_CT");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	
	
	
	public static void update_Categorielv(String NOM_CT, String DESC_CT, int id_CT) {
		try (// "+(String)N_BDD+"
				Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("UPDATE " + (String) N_BDD + ".Categorielv C SET"
						+ " C.NOM_CT=?,C.DESC_CT=? WHERE C.ID_CT=?");) {
			// administrateur
			statmnt.setString(1, NOM_CT);
			statmnt.setString(2, DESC_CT);
			statmnt.setInt(3, id_CT);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Beans.Categorielv reaserch_Categorielv(String NOM_CT) {
		Beans.Categorielv categ = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT C.* FROM " + (String) N_BDD
						+ ".Categorielv C WHERE C.ID_CT=" + GetId_Categorielv(NOM_CT));) {

			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				categ = new Categorielv(r.getInt("ID_CT"), r.getString("NOM_CT"), r.getString("DESC_CT"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categ;
	}
	public static void delete_Categorielv_S() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("DELETE " + N_BDD + ".Categorielv");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int get_max_id_Categorielv_S() {
		int ID_CT = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.ID_CT) AS MAX_ID FROM " + N_BDD + ".Categorielv A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				ID_CT = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ID_CT;
	}
	
	public static int delete_and_Order_ID_CT_asc(int id) {
		int row = 0;
		int max_id = get_max_id_Categorielv_S();
		try {
			// ----<
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_BDD + ".Categorielv A WHERE A.ID_CT=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, id);
			p1.execute();
			for (int i = id; i < max_id; i++) {
				p2 = conn.prepareStatement("UPDATE " + N_BDD + ".Categorielv A SET A.ID_CT=" + (int) i
						+ " WHERE A.ID_CT=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}
	
}
