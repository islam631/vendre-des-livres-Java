package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Posseder;

public class Posseder_DAO {

	private final static String N_BDD = Class_Connection.getNome_dataBase();
	
	public static void create_Posseder(int ISBN_LV ,int ID_AUT) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn
						.prepareStatement("INSERT INTO " + (String) N_BDD + ".Posseder VALUES(?,?)");) {
			statmnt.setInt(1, ISBN_LV);
			statmnt.setInt(2, ID_AUT);
			statmnt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void delete_Posseder(int ISBN_LV ,int ID_AUT) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn
						.prepareStatement("DELETE " + N_BDD + ".Posseder C WHERE C.ISBN_LV=? AND C.ID_AUT=?");) {
			statmnt.setInt(1, ISBN_LV);
			statmnt.setInt(2, ID_AUT);
			statmnt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Beans.Posseder reaserch_Posseder(int ISBN_LV ,int ID_AUT) {
		Beans.Posseder posseder = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement statmnt = conn.prepareStatement(
						"SELECT C.* FROM " + (String) N_BDD + ".Posseder C WHERE C.ISBN_LV=? AND C.ID_AUT=?");) {
			statmnt.setInt(1, ISBN_LV);
			statmnt.setInt(2, ID_AUT);
			ResultSet r = statmnt.executeQuery();
			while (r.next()) {
				posseder = new Posseder(r.getInt("ISBN_LV"), r.getInt("ID_AUT"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return posseder;
	}
}
