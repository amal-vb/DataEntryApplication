
package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransactionDao;

@WebServlet("/saveTransaction")
public class SaveTransactionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String customerIdText = request.getParameter("customerId");
		String amountText = request.getParameter("amount");
		String dateText = request.getParameter("transactionDate");

		// Check for missing fields
		if (customerIdText == null || customerIdText.isBlank() || amountText == null || amountText.isBlank()
				|| dateText == null || dateText.isBlank()) {

			response.sendRedirect(request.getContextPath() + "/transaction?error=missing");
			return;
		}

		try {
			int customerId = Integer.parseInt(customerIdText);
			BigDecimal amount = new BigDecimal(amountText);
			Date transactionDate = Date.valueOf(dateText);

			// Validate values on the server
			if (customerId <= 0 || amount.compareTo(BigDecimal.ZERO) <= 0) {

				response.sendRedirect(request.getContextPath() + "/transaction?error=invalid");
				return;
			}

			TransactionDao dao = new TransactionDao();

			boolean saved = dao.saveTransaction(customerId, amount, transactionDate);

			if (saved) {
				response.sendRedirect(request.getContextPath() + "/transaction?success=1");
			} else {
				getServletContext().log("Transaction insert did not insert a row.");

				response.sendRedirect(request.getContextPath() + "/transaction?error=save");
			}

		} catch (IllegalArgumentException e) {
			// Includes invalid number formats and invalid SQL dates
			response.sendRedirect(request.getContextPath() + "/transaction?error=invalid");

		} catch (SQLException e) {
			// Keep technical details in the server log
			getServletContext().log("Database error while saving transaction.", e);

			response.sendRedirect(request.getContextPath() + "/transaction?error=database");
		}
	}
}
