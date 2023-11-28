package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Client_Beans;
import Beans.Livre;
import Beans.TimsTamp_Beans;
import Beans.VillCl_Beans;

public class Client_DAO {

	private final static String N_BDD = Class_Connection.getNome_dataBase();

	public static void create_Client(String NOM_CL, String PRENOM_CL, String DATEN_CL, int TEL_CL, int ID_VILLE) {

		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("INSERT INTO " + (String) N_BDD + ".client VALUES("
						+ "?,?,?,"+Beans.Client_Beans.getDate(DATEN_CL)+",?,?)");) {
			statmnt.setInt(1, (int)(get_max_id_client()+1));
			statmnt.setString(2, NOM_CL);
			statmnt.setString(3, PRENOM_CL);
			//statmnt.setDate(4, Date.valueOf(DATEN_CL));
			statmnt.setInt(4, TEL_CL);
			statmnt.setInt(5, ID_VILLE);
			statmnt.execute();
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("errur create_Client");
		}

	}
		
		


	public static int GetId_CLIENT(String EMAIL_CL) {
		int i = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn
						.prepareStatement("SELECT C.ID_CL FROM " + (String) N_BDD + ".client C , "+(String) N_BDD +".COMPTECL Cmp  WHERE C.ID_CL=Cmp.ID_CL and  Cmp.EMAIL_CMP=?");) {
			statmnt.setString(1, EMAIL_CL);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				i = r.getInt("ID_CL");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	
	
	
	
	public static void update_CLIENT(int id, String NOM_CL, String PRENOM_CL, String DATEN_CL, int TEL_CL,
			String EMAIL_CL, int ID_VILLE) {
		try (// "+(String)N_BDD+"
				Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("UPDATE " + (String) N_BDD + ".client C SET"
						+ " C.NOM_CL=?,C.PRENOM_CL=?,C.DATEN_CL=?,C.TEL_CL=?,C.EMAIL_CL=?,C.ID_VILLE=? WHERE C.ID_CL=?");) {
			// administrateur
			statmnt.setString(1, NOM_CL);
			statmnt.setString(2, PRENOM_CL);
			statmnt.setString(3, DATEN_CL);
			statmnt.setInt(4, TEL_CL);
			statmnt.setString(5, EMAIL_CL);
			statmnt.setInt(6, ID_VILLE);
			statmnt.setInt(7, id);

			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Client_Beans reaserch_CLIENT(String email) {
		Client_Beans client = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"SELECT C.* FROM " + (String) N_BDD + ".CLIENT C WHERE C.ID_CL=" + GetId_CLIENT(email));) {
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				client = new Client_Beans(r.getInt("ID_CL"), r.getString("NOM_CL"), r.getString("PRENOM_CL"),
						r.getString("DATEN_CL"), r.getInt("TEL_CL"), r.getInt("ID_VILLE"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return client;
	}
	//_____________________________________
	public static void delete_clientS() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("DELETE " + N_BDD + ".client");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

	public static int get_max_id_client() {
		int ID_CL = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.ID_CL) AS MAX_ID FROM " + N_BDD + ".client A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				ID_CL = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ID_CL;
	}
	
	
	
	public static int delete_and_Order_ID_CL_asc(int id) {
		int row = 0; 
		int max_id = get_max_id_client();
		try {
			
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_BDD + ".Client C WHERE C.id_cl=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, id);
			p1.execute();
			for (int i = id; i < max_id; i++) 
			{
				p2 = conn.prepareStatement("UPDATE " + N_BDD + ".Client C SET C.id_cl=" + (int) i
						+ " WHERE C.id_cl=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}
	public static void main(String[] args) {
		
		System.out.println(delete_and_Order_ID_CL_asc(1));
	}
	
	
	
	
	
}
