package dtu.fm13.customer.model;

import java.util.Objects;

public class Payment {
	private String payerId;
	private String recieverId;
	private float amount;
	public Payment() {
		
	}
	public Payment(String payerId,String recieverId,float amount) {
		this.payerId=payerId;
		this.recieverId=recieverId;
		this.amount=amount;
	}
	

	public String getRecieverId() {
		return recieverId;
	}

	public String getPayerId() {
		return payerId;
	}

	public float getAmount() {
		return amount;
	}
    public void setPayerId(String payerId) {
	this.payerId = payerId;
	}

	public void setRecieverId(String recieverId) {
		this.recieverId = recieverId;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Payment payment = (Payment) obj;
	    return Objects.equals(amount,payment.amount) &&
	    		Objects.equals(payerId,payment.payerId) &&
	    		Objects.equals(recieverId,payment.recieverId);
	}
	@Override
    public int hashCode() {
        return Objects.hash(payerId, recieverId,amount);
    }
}


