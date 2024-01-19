package dtu.fm13.models;


import java.security.Timestamp;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentMessage {
	private UUID id;
	private String accountID;
	private Timestamp deleted;
	public void setDeleted(Timestamp deleted) {
		this.deleted = deleted;
	}
}
