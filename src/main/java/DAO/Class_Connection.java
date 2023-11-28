package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class Class_Connection {
	
	private final static String nome_dataBase = "SAOISTORE";
	
	public static Connection conn_oracle_jdbc() throws SQLException {
		OracleDataSource ods=new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		ods.setUser("system");
		ods.setPassword("gt63se63s");
		return (Connection)ods.getConnection();
	}

	public static String getNome_dataBase() {
		return nome_dataBase;
	}
	
}
