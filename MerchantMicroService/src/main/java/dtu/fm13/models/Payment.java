/*Harald
 */
package dtu.fm13.models;

import java.util.UUID;

public class Payment {

    private UUID payerToken;
    
	private UUID merchantId;
    private int amount;

    public Payment() {
    }

    public Payment(UUID payerId, UUID recieverId, int amount) {
        this.payerToken = payerId;
        this.merchantId = recieverId;
        this.amount = amount;
    }

   
    public UUID getPayerToken() {
        return payerToken;
    }

    public UUID getMerchantId() {
        return merchantId;
    }

    public int getAmount() {
        return amount;
    }
    public void setPayerToken(UUID payerId) {
		this.payerToken = payerId;
	}

	public void setMerchantId(UUID recieverId) {
		this.merchantId = recieverId;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}