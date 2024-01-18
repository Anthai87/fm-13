/*Harald
 */
package dtu.fm13.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private UUID payerToken;
	private UUID merchantId;
    private int amount;

	

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment payment = (Payment) obj;
        return Objects.equals(amount, payment.amount) &&
                Objects.equals(payerToken, payment.getPayerToken()) &&
                Objects.equals(merchantId, payment.merchantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payerToken, merchantId, amount);
    }
}


