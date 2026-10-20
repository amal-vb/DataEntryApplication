package model;

public class Customer {
	private int customerId;
	private String customerName;
	private String customerPhone;

	public Customer(int customerId, String customerName, String customerPhone) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
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
}
