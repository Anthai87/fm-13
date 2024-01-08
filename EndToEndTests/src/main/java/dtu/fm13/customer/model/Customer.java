package dtu.fm13.customer.model;

import java.util.Objects;

public class Customer {
    private int id;
	private String name;
	private String address;
	public Customer() {}
	
	public Customer(String name, String address) {	
		this.name = name;
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(address, customer.address);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(id, name,address);
    }
}
