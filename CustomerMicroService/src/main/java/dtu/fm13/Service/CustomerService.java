/*Harald
 */

package dtu.fm13.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.models.Account;
import dtu.fm13.models.TokenRequest;
import dtu.fm13.repository.CustomerRepository;
import dtu.fm13.Service.CustomerService;
import dtu.fm13.interfaces.PaymentInterface;
import dtu.fm13.interfaces.TokenInterface;

public class CustomerService {

    private CustomerRepository customerRepository;
    private PaymentInterface paymentInterface = new PaymentInterface();
    private TokenInterface tokenInterface = new TokenInterface();

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Account> getCustomers() {
        return customerRepository.getCustomers();
    }

    public UUID createCustomer(Account c) {
        Account customer = new Account();
        customer.setAccountID(c.getAccountID());
        customerRepository.addCustomer(customer);
        // add to PaymentService
        paymentInterface.addCustomer(customer);
        return customer.getId();
    }

    public boolean deleteCustomer(String customerID) {
        try {
            int listSize = customerRepository.getCustomers().size();
            List<Account> newlist = customerRepository.getCustomers();
            newlist.removeIf(c -> c.getId().equals(UUID.fromString(customerID)));
            if (listSize == newlist.size())
                return false;
            customerRepository.setCustomers(newlist);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean exists(String accountID) {
        return customerRepository.existsCustomer(UUID.fromString(accountID));
    }

    public List<String> getTokens(String customerID) {
        List<TokenRequest> tokens = tokenInterface.tokenlist(customerID);
        List<String> tokenAsStrings = new ArrayList<>();
        for (TokenRequest t : tokens) {
            tokenAsStrings.add(t.getToken().toString());
        }
        return tokenAsStrings;
    }
}