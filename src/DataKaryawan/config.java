package DataKaryawan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class config {
	private static Connection MySQLConfig;
	
	public static Connection configDB() throws SQLException {
		try {
			String urlString = "jdbc:mysql://localhost:3306/tugasjavaapplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String userString = "root";
			String passwordString = "";
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			MySQLConfig = DriverManager.getConnection(urlString, userString, passwordString);
		} catch (SQLException e) {
			System.out.println("Koneksi ke database gagal!");
		}
		return MySQLConfig;
	}
}
