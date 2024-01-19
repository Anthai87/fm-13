/**
 *
 * @author Harald
 *
 * */
package dtu.fm13.Payment.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.Payment.models.Account;
import dtu.fm13.Payment.models.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRepository {
    private List<Account> customers = new ArrayList<>();

    public boolean merchantExists(UUID payerId) {
        for (Account c : customers) {
            if (c.getId().equals(payerId))
                return true;
        }
        return false;
    }

    public String getCustomerBankID(UUID payerId) {
        for (Account c : customers) {
            if (c.getId().equals(payerId))
                return c.getAccountID();
        }
        return null;
    }

    public boolean addCustomer(Account customer) {
        if (merchantExists(customer.getId()))
            return false;
        customers.add(customer);
        return true;
    }
}
