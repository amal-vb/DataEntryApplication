
package dao;

import java.sql.SQLException;
import java.util.List;

import model.Customer;

public class CustomerDaoTest {

	public static void main(String[] args) {

		CustomerDao dao = new CustomerDao();

		try {
			List<Customer> customers = dao.getAllCustomers();

			for (Customer customer : customers) {
				System.out.println(customer.getCustomerId() + " | " + customer.getCustomerName() + " | "
						+ customer.getCustomerPhone());
			}

			System.out.println("Total customers: " + customers.size());

		} catch (SQLException e) {
			System.out.println("Failed to retrieve customers.");
			e.printStackTrace();
		}
	}
}
