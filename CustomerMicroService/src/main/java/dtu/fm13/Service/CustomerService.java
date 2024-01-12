/*Interface for the Customer MicroService
 * implements:
 * Customer 
 * - get
 * - post
 * - delete
 * needs:
 * Customer/?name={name}
 */

 package dtu.fm13.Service;

 import java.util.List;
 import java.util.UUID;
 
 import dtu.fm13.models.Customer;
 import dtu.fm13.repository.CustomerRepository;
 import dtu.fm13.Service.CustomerService;
 public class CustomerService {
 
     private CustomerRepository customerRepository;
 
     public CustomerService(CustomerRepository customerRepository) {
         this.customerRepository = customerRepository;
     }
 
     public List<Customer> getCustomers() {
         return customerRepository.getCustomers();
     }
 
     public UUID createCustomer(String accountID) {
         
         Customer customer = new Customer();
         //customer.setId(customerID);
         customer.setAccountID(accountID);
         System.out.println(accountID);
         customerRepository.addCustomer(customer);
         return customer.getId();
     }
 
     public void deleteCustomer(Customer customer) {
         
         try {
             List<Customer> newlist = customerRepository.getCustomers();
             newlist.removeIf(p -> p.getId() == customer.getId());
             customerRepository.setCustomers(newlist);
 
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
 
     }
 
    
 
 }