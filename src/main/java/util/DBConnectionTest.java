package util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
	public static void main(String[] args) {
		try (Connection con = DBConnection.getConnection()) {
			System.out.println("Database connected");
		} catch (SQLException e) {
			System.out.println("Database Connection Failed");
			e.printStackTrace();
		}
	}
}
