package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Client_Beans;
import Beans.CompteCL;

public class CompteCL_DAO {

	private final static String N_BDD = Class_Connection.getNome_dataBase();

	public static void create_CompteCL( String EMAIL_CMP, String MOTDP_CMP, int ID_CL) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("INSERT INTO " + (String) N_BDD + ".CompteCL VALUES("
						+"?,?,?,?)");) {
			statmnt.setInt(1, (int)(get_max_id_CompteCL_S()+1));
			statmnt.setString(2, EMAIL_CMP);
			statmnt.setString(3, MOTDP_CMP);
			statmnt.setInt(4, ID_CL);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("errur create_CompteCL");
		}

	}

	
	public static int GetId_CompteCL(String EMAIL_CMP) {
		int i = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement
				("SELECT C.ID_CMP FROM " + (String) N_BDD + ".CompteCL C WHERE C.EMAIL_CMP=?");//on a modifié ca elle etait numut pas email
			) 
		{
			statmnt.setString(1, EMAIL_CMP);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				i = r.getInt("ID_CMP");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	
	

	

	public static void update_CompteCL(int ID_CMP,  String EMAIL_CMP, String MOTDP_CMP, int ID_CL) {
		try (// "+(String)N_BDD+"
				Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("UPDATE " + (String) N_BDD + ".CompteCL C SET"
						+ " C.EMAIL_CMP=?,C.MOTDP_CMP=?,C.ID_CL=? WHERE C.ID_CMP=?");) {
			// administrateur
			statmnt.setString(1, EMAIL_CMP);
			statmnt.setString(2, MOTDP_CMP);
			statmnt.setInt(3, ID_CL);
			statmnt.setInt(4, ID_CMP);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static CompteCL reaserch_CompteCL(String NOMUTILI_CMP) {
		CompteCL compte = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT C.* FROM " + (String) N_BDD
						+ ".CompteCL C WHERE C.ID_CMP=" + GetId_CompteCL(NOMUTILI_CMP));) {

			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				compte = new CompteCL(r.getInt("ID_CMP"),  r.getString("EMAIL_CMP"),
						r.getString("MOTDP_CMP"), r.getInt("ID_CL"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return compte;
	}
	
	public static int connecterUt(String email , String password) {
		int i = 0;
		String EMAIL_CMP = null;
		String MOTDP_CMP = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p1 = conn.prepareStatement(
						"SELECT CC.EMAIL_CMP FROM " + N_BDD + ".COMPTECL CC WHERE CC.MOTDP_CMP=?"); // RETURN
																												// NOME_UTILISATEUR
				PreparedStatement p2 = conn.prepareStatement(
						"SELECT CC.MOTDP_CMP FROM " + N_BDD + ".COMPTECL CC WHERE CC.EMAIL_CMP=?");// RETURN
																												// PASSWORD
		) {
			p1.setString(1, password);
			ResultSet r1 = p1.executeQuery();
			// _________________
			p2.setString(1, email);
			ResultSet r2 = p2.executeQuery();

			while (r1.next()) {
				EMAIL_CMP = r1.getString("EMAIL_CMP");

			}	
			while (r2.next()) {
				MOTDP_CMP = r2.getString("MOTDP_CMP");
			}
			
				   if (EMAIL_CMP == null && MOTDP_CMP == null) 
				   {
					   
				   }
				   else if (EMAIL_CMP != null && MOTDP_CMP != null) 
				   {
					   i = 1;
				   }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
		
	}
	
	
	
	public static void delete_CompteCL_S() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("DELETE " + N_BDD + ".CompteCL");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int get_max_id_CompteCL_S() {
		int ID_CMP = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.ID_CMP) AS MAX_ID FROM " + N_BDD + ".CompteCL A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				ID_CMP = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ID_CMP;
	}
	
	
	
	public static  Beans.Client_Beans GetClient(String email , String password) {
		 Beans.Client_Beans bmw = null;
		 
		 try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
					PreparedStatement p = (PreparedStatement) conn
							.prepareStatement("SELECT CL.* From " + N_BDD +".Client CL , " + N_BDD +".CompteCL Cmp where CL.id_cl = Cmp.id_cl and Cmp.EMAIL_Cmp =? and Cmp.MOTDP_CMP =? ");) 
		 	{
			 	p.setString(1, email);
			 	p.setString(2, password);
				ResultSet r = p.executeQuery();
				while (r.next()) {
					bmw = new Client_Beans 
							(
									r.getInt("ID_CL"),
									r.getString("NOM_CL"),
									r.getString("PRENOM_CL"),
									r.getString("DATEN_CL"),
									r.getInt("TEL_CL"),
									r.getInt("ID_VILLE")
							);
				}	
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		 
		 
		return bmw;
	}
	
	
	
	
	
	public static int delete_and_Order_ID_CMP_asc(int id) {
		int row = 0;
		int max_id = get_max_id_CompteCL_S();
		try {
			// ----<
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_BDD + ".CompteCL A WHERE A.ID_CMP=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, id);
			p1.execute();
			for (int i = id; i < max_id; i++) {
				p2 = conn.prepareStatement("UPDATE " + N_BDD + ".CompteCL A SET A.ID_CMP=" + (int) i
						+ " WHERE A.ID_CMP=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}
	
	public static ArrayList<Beans.CompteCL>  GetCompClient()
	
	{
		
		ArrayList<Beans.CompteCL> ComptCl = new ArrayList<>();
		try (
				Connection conn=Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=conn.prepareStatement("SELECT C.ID_CMP , C.EMAIL_CMP  FROM "+N_BDD+".COMPTECL C ORDER BY C.ID_CMP ASC");
				)
		{
			ResultSet r=p.executeQuery();
			
			while (r.next()) 
			{
				ComptCl.add(new CompteCL
						(
								r.getInt("ID_CMP"),
								r.getString("EMAIL_CMP"),
								null,
								0
								)
						);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return ComptCl;
	}
	
	
	
	
}
