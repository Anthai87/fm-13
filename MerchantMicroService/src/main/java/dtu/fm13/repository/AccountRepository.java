/*Harald
 */
package dtu.fm13.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.models.Account;
import dtu.fm13.models.Payment;
import lombok.Data;
@Data
public class AccountRepository {

    private List<Payment> payments = new ArrayList<>();
    private List<Account> merchants = new ArrayList<>();

    public List<Account> getMerchants() {
        return merchants;
    }

    public AccountRepository() {
    }

    public void setMerchants(List<Account> merchants) {
        this.merchants = merchants;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void addCustomer(Account customer) {
        //TODO check CPR if exists already
        customer.setId(UUID.randomUUID());
        merchants.add(customer);
    }

    public boolean existsCustomer(UUID id) {
        for (Account customer : getMerchants()) {
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }
    public String getAccountBankID(UUID uuid) {
    	for (Account account: merchants) {
    		if (account.getId().equals(uuid)) {
    			return account.getAccountID();
    		}
    	}
    	return null;
    }

}


