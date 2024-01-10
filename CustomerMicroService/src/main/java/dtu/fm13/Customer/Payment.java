package dtu.fm13.Customer;


public class Payment {

    private String payerId;
    
	private String recieverId;
    private float amount;

    public Payment() {
    }

    public Payment(String payerId, String recieverId, float amount) {
        this.payerId = payerId;
        this.recieverId = recieverId;
        this.amount = amount;
    }

   
    public String getPayerId() {
        return payerId;
    }

    public String getRecieverId() {
        return recieverId;
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

}