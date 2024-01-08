package dtu.redGreenRefactor.main.model;


public class Payment {

    private int payerId;
    
	private int recieverId;
    private float amount;

    public Payment() {
    }

    public Payment(int payerId, int recieverId, float amount) {
        this.payerId = payerId;
        this.recieverId = recieverId;
        this.amount = amount;
    }

   
    public int getPayerId() {
        return payerId;
    }

    public int getRecieverId() {
        return recieverId;
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

}