package dtu.fm13.customer.model;

import java.util.Objects;

public class Payment {
	private int payerId;
	private int recieverId;
	private float amount;
	public Payment() {
		
	}
	public Payment(int payerId,int recieverId,float amount) {
		this.payerId=payerId;
		this.recieverId=recieverId;
		this.amount=amount;
	}
	

	public int getRecieverId() {
		return recieverId;
	}

	public int getPayerId() {
		return payerId;
	}

	public float getAmount() {
		return amount;
	}
    public void setPayerId(int payerId) {
	this.payerId = payerId;
	}

	public void setRecieverId(int recieverId) {
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
	    return amount == payment.amount &&
	            payerId == payment.payerId &&
	            recieverId == payment.recieverId;
	}
	@Override
    public int hashCode() {
        return Objects.hash(payerId, recieverId,amount);
    }
}


