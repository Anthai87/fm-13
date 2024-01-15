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
 
     public UUID createCustomer(String accountID) {
         System.out.println("Create customer, with BankID :" + accountID);
         Customer customer = new Customer();
         customer.setAccountID(accountID);
         customerRepository.addCustomer(customer);
        //add to PaymentService
        paymentInterface.addCustomer(customer);

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

    public boolean exists(String accountID) {
        return customerRepository.existsCustomer(UUID.fromString(accountID));
    }
 
    
 
 }