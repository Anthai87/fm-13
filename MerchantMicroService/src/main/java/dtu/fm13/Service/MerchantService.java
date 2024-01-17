/*Harald
 */

 package dtu.fm13.Service;

 import java.util.List;
 import java.util.UUID;
 
import dtu.fm13.repository.AccountRepository;
import dtu.fm13.Service.MerchantService;
import dtu.fm13.interfaces.PaymentInterface;
import dtu.fm13.models.Account;
 public class MerchantService {
 
    private AccountRepository merchantRepository;
    private PaymentInterface paymentInterface= new PaymentInterface();
    public MerchantService(AccountRepository customerRepository) {
         this.merchantRepository = customerRepository;
     }
 
     public List<Account> getCustomers() {
         return merchantRepository.getMerchants();
     }
 
     public UUID createMerchant(Account cust) {
         System.out.println("Create customer, with BankID :" + cust.getAccountID());
         Account merchant = new Account();
         merchant.setAccountID(cust.getAccountID());
         merchantRepository.addCustomer(merchant);
        //add to PaymentService
        paymentInterface.addAccount(merchant);

         return merchant.getId();
     }
 
     public boolean deleteCustomer(String customerID) {
        try {
            int listSize = merchantRepository.getMerchants().size();
             List<Account> newlist = merchantRepository.getMerchants();
             newlist.removeIf(c -> c.getId().equals(UUID.fromString(customerID)));
            if (listSize == newlist.size()) return false; 
            merchantRepository.setMerchants(newlist);
            return true;
        } catch (Exception e) {
            return false;
        } 
            
         
     }

    public boolean exists(String accountID) {
        return merchantRepository.existsCustomer(UUID.fromString(accountID));
    }
 
    
 
 }