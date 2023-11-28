package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Admin;
import Beans.Client_Beans;
import Beans.Livre;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

public class Admin_DAO {
	private final static String N_BDD = Class_Connection.getNome_dataBase();
	public static void create_Admin(String NOM_ADMIN, String PRENOM_ADMIN, String EMAIL_ADMIN, String MOTDP_ADMIN) {
		/*create_Admin("Taha1", "Chenaa1", "email", "123");
		create_Admin("Taha2", "Chenaa2", "email", "123");
		create_Admin("Taha3", "Chenaa3", "email", "123");
		create_Admin("Taha4", "Chenaa4", "email", "123");
		create_Admin("Taha5", "Chenaa5", "email", "123");
		create_Admin("Taha6", "Chenaa6", "email", "123");
		create_Admin("Taha7", "Chenaa7", "email", "123");
		create_Admin("Taha8", "Chenaa8", "email", "123");
		create_Admin("Taha9", "Chenaa9", "email", "123");
		create_Admin("Taha10", "Chenaa10", "email", "123");*/
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("INSERT INTO " + (String) N_BDD
						+ ".administrateur(ID_ADMIN,NOM_ADMIN,PRENOM_ADMIN,EMAIL_ADMIN,MOTDP_ADMIN)" + "VALUES(?,?,?,?,?)");) {
			statmnt.setInt(1, (int)get_max_idAdmin()+1);
			statmnt.setString(2, NOM_ADMIN);
			statmnt.setString(3, PRENOM_ADMIN);
			statmnt.setString(4, EMAIL_ADMIN);
			statmnt.setString(5, MOTDP_ADMIN);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int GetIdAdmin(String email, String Pasword) {
		int i = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT A.ID_ADMIN FROM " + (String) N_BDD
						+ ".administrateur A WHERE A.EMAIL_ADMIN=? AND A.MOTDP_ADMIN=?");) {
			statmnt.setString(1, email);
			statmnt.setString(2, Pasword);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				i = r.getInt("ID_ADMIN");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	public static void delete_Admins(){
		try (
				Connection conn=(Connection)Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=(PreparedStatement)conn.prepareStatement("DELETE "+N_BDD+".administrateur");
				){
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static int get_max_idAdmin() {
		int ID_ADMIN=0;
		try (
				Connection conn=(Connection)Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=(PreparedStatement)conn.
						prepareStatement("SELECT MAX(A.ID_ADMIN) AS MAX_ID FROM "+N_BDD+".administrateur A");
				){
			ResultSet r= p.executeQuery();
			while (r.next()) {
				ID_ADMIN=r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ID_ADMIN;
	}
	
	public static int delete_and_Order_ID_ADMIN_asc(int id) {
		int row=0;
		int max_id=get_max_idAdmin();
		try {
			//----<
			Connection conn=Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn
					.prepareStatement("DELETE " + N_BDD + ".administrateur A WHERE A.ID_ADMIN=?");//--->
			PreparedStatement p2=null;
			p1.setInt(1, id);
			p1.execute();
				for(int i=id;i<max_id;i++) {
					p2=conn.prepareStatement("UPDATE "+N_BDD+".administrateur A SET A.ID_ADMIN="+(int)i+" WHERE A.ID_ADMIN="+(int)(i+1));
					row=p2.executeUpdate();
				}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}
	public static void update_Admin(int ID_ADMIN, String NOM_ADMIN, String PRENOM_ADMIN, String EMAIL_ADMIN,
			String MOTDP_ADMIN) {
		try (// "+(String)N_BDD+"
				Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn
						.prepareStatement("UPDATE " + (String) N_BDD + ".administrateur A SET A.NOM_ADMIN=?,"
								+ "A.PRENOM_ADMIN=?,A.EMAIL_ADMIN=?,A.MOTDP_ADMIN=? WHERE A.ID_ADMIN=?");) {
			// administrateur
			statmnt.setString(1, NOM_ADMIN);
			statmnt.setString(2, PRENOM_ADMIN);
			statmnt.setString(3, EMAIL_ADMIN);
			statmnt.setString(4, MOTDP_ADMIN);
			statmnt.setInt(5, ID_ADMIN);
			statmnt.execute();
			System.out.println("oki");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Admin reaserch_Admin(String email, String mot_pass) {
		Admin admn = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement("SELECT A.* FROM " + (String) N_BDD
						+ ".administrateur A WHERE A.ID_ADMIN=" + GetIdAdmin(email, mot_pass));) {
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				admn = new Admin(r.getInt("ID_ADMIN"), r.getString("NOM_ADMIN"), r.getString("PRENOM_ADMIN"),
						r.getString("EMAIL_ADMIN"), r.getString("MOTDP_ADMIN"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return admn;
	}
	
	
	public static int connecterAd(String EMAIL_ADMIN , String MOTDP_ADMIN) {
		int i = 0;//administrateur
		String EMAIL_AD = null;
		String MOTDP_AD = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p1 = conn.prepareStatement(
						"SELECT CC.EMAIL_ADMIN FROM " + N_BDD + ".administrateur CC WHERE CC.MOTDP_ADMIN=?"); // RETURN
																												// NOME_UTILISATEUR
				PreparedStatement p2 = conn.prepareStatement(
						"SELECT CC.MOTDP_ADMIN FROM " + N_BDD + ".administrateur CC WHERE CC.EMAIL_ADMIN=?");// RETURN
																												// PASSWORD
		) {
			p1.setString(1, MOTDP_ADMIN);
			ResultSet r1 = p1.executeQuery();
			// _________________
			p2.setString(1, EMAIL_ADMIN);
			ResultSet r2 = p2.executeQuery();

			while (r1.next()) {
				EMAIL_AD = r1.getString("EMAIL_ADMIN");

			}	
			while (r2.next()) {
				MOTDP_AD = r2.getString("MOTDP_ADMIN");
			}
			
				   if (EMAIL_AD == null && MOTDP_AD == null) 
				   {
					   
				   }
				   else if (EMAIL_AD != null && MOTDP_AD != null) 
				   {
					   i = 1;
				   }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
		
	}
	
	public static  Beans.Admin GetAdmin(String email , String password) {
		 Beans.Admin bmw = null;
		 
		 try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
					PreparedStatement p = (PreparedStatement) conn
							.prepareStatement("SELECT * From " + N_BDD +".ADMINISTRATEUR where EMAIL_ADMIN =? and MOTDP_ADMIN =?");) 
		 	{
			 	p.setString(1, email);
			 	p.setString(2, password);
				ResultSet r = p.executeQuery();
				while (r.next()) {//Admin(int iD_ADMIN, String nOM_ADMIN, String pRENOM_ADMIN, String pRENOM_ADMIN, String mOTDP_ADMIN)
					bmw = new Admin(
							r.getInt("ID_ADMIN"),
							r.getString("NOM_ADMIN"),
							r.getString("PRENOM_ADMIN"),
							r.getString("EMAIL_ADMIN"),
							r.getString("MOTDP_ADMIN")
							);
				}	
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		 
		 
		return bmw;
	}
	
	
	public static ArrayList<Beans.Admin>  Getadmin()
	{
		String[][] String_admin=null;
		ArrayList<Beans.Admin> admin=new ArrayList<>();
		try (
				Connection conn=Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=conn.prepareStatement("SELECT Ad.ID_ADMIN , Ad.NOM_ADMIN , Ad.EMAIL_ADMIN FROM "+N_BDD+".ADMINISTRATEUR Ad ORDER BY Ad.ID_ADMIN ASC");
				)
		{
			ResultSet r=p.executeQuery();
			
			while (r.next()) {
				admin.add(new Admin
							(
							r.getInt("ID_ADMIN"),
							r.getString("NOM_ADMIN"),
							null,
							r.getString("EMAIL_ADMIN"),
							null
							)
					);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return admin;
	}


}
