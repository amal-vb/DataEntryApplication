
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Transaction;
import util.DBConnection;

public class TransactionDao {

	// Save a new transaction to the database
	public boolean saveTransaction(int customerId, BigDecimal amount, Date transactionDate) throws SQLException {

		String sql = "INSERT INTO transactions " + "(customer_id, transaction_amount, transaction_date) "
				+ "VALUES (?, ?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, customerId);
			ps.setBigDecimal(2, amount);
			ps.setDate(3, transactionDate);

			return ps.executeUpdate() == 1;
		}
	}

	// Retrieve all transactions with customer details
	public List<Transaction> getAllTransactions() throws SQLException {

		List<Transaction> transactions = new ArrayList<>();

		String sql = "SELECT t.transaction_id, t.customer_id, " + "c.customer_name, c.customer_phone, "
				+ "t.transaction_amount, t.transaction_date " + "FROM transactions t " + "INNER JOIN customers c "
				+ "ON t.customer_id = c.customer_id " + "ORDER BY t.transaction_id DESC";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				Transaction transaction = new Transaction(rs.getInt("transaction_id"), rs.getInt("customer_id"),
						rs.getString("customer_name"), rs.getString("customer_phone"),
						rs.getBigDecimal("transaction_amount"), rs.getDate("transaction_date"));

				transactions.add(transaction);
			}
		}

		return transactions;
	}
}
