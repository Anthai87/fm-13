
package dtu.fm13.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dtu.fm13.models.Customer;
import dtu.fm13.models.Payment;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportRepository {

    private List<Payment> payments = new ArrayList<>();
   // private List<Customer> customers = new ArrayList<>();

    public ReportRepository() {
    }

/*    public void addCustomer(Customer customer) {
        //TODO check CPR if exists already
        customer.setId(UUID.randomUUID());
        customers.add(customer);
    }*/

//    public boolean existsCustomer(UUID id) {
//        for (Customer customer : getPayments()) {
//            if (customer.getId().equals(id)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }
 /*   public String getCustomerBankID(UUID uuid) {
    	for (Customer cust: payments) {
    		if (cust.getId().equals(uuid)) {
    			return cust.getAccountID();
    		}
    	}
    	return null;
    }*/
}


