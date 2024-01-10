package dtu.fm13.customer.model;

import java.util.Objects;

public class Customer {
    private String id;
    
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
        return Objects.equals(id,customer.id) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName)
                ;
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(id,cpr, firstName,lastName);
    }


	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
