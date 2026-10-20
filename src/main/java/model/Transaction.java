package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {

	private int transactionId;
	private int customerId;
	private String customerName;
	private String customerPhone;
	private BigDecimal transactionAmount;
	private Date transactionDate;

	public Transaction(int transactionId, int customerId, String customerName, String customerPhone,
			BigDecimal transactionAmount, Date transactionDate) {

		this.transactionId = transactionId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}
}
