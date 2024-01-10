package dtu.fm13.customer.model;

import java.util.Objects;
import java.util.UUID;

public class Payment {
	private UUID payerId;
	private UUID recieverId;
	private int amount;
	public Payment() {
		
	}
	public Payment(UUID payerId,UUID recieverId,int amount) {
		this.payerId=payerId;
		this.recieverId=recieverId;
		this.amount=amount;
	}
	

	public UUID getRecieverId() {
		return recieverId;
	}

	public UUID getPayerId() {
		return payerId;
	}

	public float getAmount() {
		return amount;
	}
    public void setPayerId(UUID payerId) {
	this.payerId = payerId;
	}

	public void setRecieverId(UUID recieverId) {
		this.recieverId = recieverId;
	}

	public void setAmount(int amount) {
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


