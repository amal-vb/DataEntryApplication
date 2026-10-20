package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import util.DBConnection;

public class CustomerDao {
	public List<Customer> getAllCustomers() throws SQLException {
		List<Customer> customers = new ArrayList<>();

		String sql = "SELECT customer_id, customer_name, customer_phone " + "FROM customers " + "ORDER BY customer_name";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("customer_id");
				String name = rs.getString("customer_name");
				String phone = rs.getString("customer_phone");

				Customer customer = new Customer(id, name, phone);

				customers.add(customer);
			}

		}
		return customers;
	}

}
