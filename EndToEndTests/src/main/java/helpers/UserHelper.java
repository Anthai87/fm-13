package helpers;

import java.math.BigDecimal;

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
		this.customer.setCprNumber("1234567890");
		this.customer.setFirstName("Dummy");
		this.customer.setLastName("data");
		this.merchant.setCprNumber("567890");
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

	public String getBankID(User user) {
		String bankID = null;
		for (AccountInfo account : bankService.getAccounts()) {
			if (account.getUser().getCprNumber().equals(user.getCprNumber())) {
			
				bankID = account.getAccountId();
			}
		}
		
		if (bankID==null) {
			try {
				 bankID =bankService.createAccountWithBalance(user, new BigDecimal(1));
			} catch (BankServiceException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bankID;
	}
//	public void createNewCustomer(User user) {
//		this.customer = user;
//	}
	
	
	
	
	//create user
	//get bank id
	//register with bank
}
