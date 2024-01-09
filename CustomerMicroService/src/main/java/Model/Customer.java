package Model;

public class Customer {
    private int id;
	private String name;
	private String address;
	public Customer() {}
	public Customer(String name, String address) {
		this.name=name;
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
	public String toString() {
		return this.name + " " +  this.address;
	}
	
}
