package dtu.fm13.models;

import java.util.UUID;

public class Payment {

    private UUID payerId;
    
	private UUID recieverId;
    private int amount;

    public Payment() {
    }

    public Payment(UUID payerId, UUID recieverId, int amount) {
        this.payerId = payerId;
        this.recieverId = recieverId;
        this.amount = amount;
    }

   
    public UUID getPayerId() {
        return payerId;
    }

    public UUID getRecieverId() {
        return recieverId;
    }

    public int getAmount() {
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

}