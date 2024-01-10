package dtu.fm13.customer.model;

import java.util.Objects;
import java.util.UUID;

public class Customer {
    private UUID id;
    
	private String cpr;
	private String firstName;
	private String lastName;
	public Customer() {}
	
	public Customer(String name, String address) {	
		this.firstName = name;
		this.lastName=address;
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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id,customer.id);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(id);
    }


	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
