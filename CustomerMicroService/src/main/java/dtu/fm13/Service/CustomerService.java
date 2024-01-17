/*Harald
 */

 package dtu.fm13.Service;

 import java.util.List;
 import java.util.UUID;
 
 import dtu.fm13.models.Customer;
 import dtu.fm13.repository.CustomerRepository;
 import dtu.fm13.Service.CustomerService;
import dtu.fm13.interfaces.PaymentInterface;
 public class CustomerService {
 
    private CustomerRepository customerRepository;
    private PaymentInterface paymentInterface= new PaymentInterface();
    public CustomerService(CustomerRepository customerRepository) {
         this.customerRepository = customerRepository;
     }
 
     public List<Customer> getCustomers() {
         return customerRepository.getCustomers();
     }
 
     public UUID createCustomer(Customer cust) {
         System.out.println("Create customer, with BankID :" + cust.getAccountID());
         Customer customer = new Customer();
         customer.setAccountID(cust.getAccountID());
         customerRepository.addCustomer(customer);
        //add to PaymentService
        paymentInterface.addCustomer(customer);

         return customer.getId();
     }
 
     public boolean deleteCustomer(String customerID) {
        try {
            int listSize = customerRepository.getCustomers().size();
             List<Customer> newlist = customerRepository.getCustomers();
             newlist.removeIf(c -> c.getId().equals(UUID.fromString(customerID)));
            if (listSize == newlist.size()) return false; 
            customerRepository.setCustomers(newlist);
            return true;
        } catch (Exception e) {
            return false;
        } 
            
         
     }

    public boolean exists(String accountID) {
        return customerRepository.existsCustomer(UUID.fromString(accountID));
    }
 
    
 
 }