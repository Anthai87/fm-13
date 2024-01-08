package dtu.redGreenRefactor;

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
	
	public boolean equals(Payment payment) {
		if (payment.getAmount() == this.amount && payment.getPayerId() == this.payerId && payment.getRecieverId() == this.recieverId) {
				return true;
		}
		return false;
	}
}


