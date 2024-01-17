/*Harald
 */
package dtu.fm13.Payment.models;

import java.security.Timestamp;
import java.util.UUID;

public class account {
	private UUID id;
	private String accountID;
	private Timestamp deleted;
	public void setDeleted(Timestamp deleted) {
		this.deleted = deleted;
	}


	public Timestamp getDeleted() {
		return deleted;
	}


	public account() {
		id = UUID.randomUUID();
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

}
