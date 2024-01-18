/* Anthony & Harald
 */
package dtu.fm13.helpers;

import java.math.BigDecimal;
import java.util.UUID;

import dtu.ws.fastmoney.Account;
import dtu.ws.fastmoney.AccountInfo;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import dtu.ws.fastmoney.User;

public class UserHelper {
	User customer = new User();
	User merchant = new User();
	private final BankService bankService = new BankServiceService().getBankServicePort();

	public UserHelper() {
		this.customer.setCprNumber(UUID.randomUUID().toString());
		this.customer.setFirstName("Dummy");
		this.customer.setLastName("data");
		this.merchant.setCprNumber(UUID.randomUUID().toString());
		this.merchant.setFirstName("mDummy");
		this.merchant.setLastName("mdata");
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public User getMerchant() {
		return merchant;
	}

	public void setMerchant(User merchant) {
		this.merchant = merchant;
	}

	public String createBankAccount(User user, int amount) {
		String bankID = null;

		try {

			bankID = bankService.createAccountWithBalance(user, new BigDecimal(amount));
		} catch (BankServiceException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return bankID;
	}

	public String getBankID(User user) {
		String bankID = "";
		try {
			Account Bankaccount= bankService.getAccount(user.getCprNumber());
			bankID=Bankaccount.getId();
		} catch (BankServiceException_Exception e) {
			bankID=createBankAccount(user,1000);
		}
			
		

		return bankID;
	}

}
