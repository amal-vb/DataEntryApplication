package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CustomerDao dao = new CustomerDao();

			List<Customer> customers = dao.getAllCustomers();

			request.setAttribute("customers", customers);

			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (SQLException e) {
			throw new ServletException("Unable to retrieve customers from database", e);
		}
	}
}