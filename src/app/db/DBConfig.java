package app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConfig {
	
	private static Connection connection;
	
	private static String url = "jdbc:mysql://wm63be5w8m7gs25a.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/et5rzzta7qvf93ax";
	private static String user = "v3p7ly6ywgk5teco";
	private static String password = "xol6bgb66yb59pr4";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Boolean closeConnection() {
		Boolean fechada = false;
		try {
			connection.close();
			fechada = connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fechada;
	}
	
	

}
