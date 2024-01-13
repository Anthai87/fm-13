package dtu.fm13.models;

import java.util.UUID;

public class Customer {
	private UUID id;
	private String accountID;

	private String cpr;
	private String firstName;
	private String lastName;

	public Customer() {
		id = UUID.randomUUID();
	}

	public Customer(String name, String address) {
		this.firstName = name;
		this.lastName = address;
		id = UUID.randomUUID();

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String address) {
		this.lastName = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

}