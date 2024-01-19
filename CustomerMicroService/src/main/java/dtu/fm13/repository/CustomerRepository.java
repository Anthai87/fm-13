/*Harald
 */
package dtu.fm13.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import dtu.fm13.models.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerRepository {

    private List<Account> customers = new ArrayList<>();

    public void addCustomer(Account customer) {
        if (existsCustomer(customer.getId())) return;
        customer.setId(UUID.randomUUID());
        customers.add(customer);
    }

    public boolean existsCustomer(UUID id) {
        for (Account customer : getCustomers()) {
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String getCustomerBankID(UUID uuid) {
    	for (Account cust: customers) {
    		if (cust.getId().equals(uuid)) {
    			return cust.getAccountID();
    		}
    	}
    	return null;
    }
}


