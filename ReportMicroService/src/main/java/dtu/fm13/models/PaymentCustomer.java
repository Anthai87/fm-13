package dtu.fm13.models;


import java.security.Timestamp;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class PaymentCustomer {
	private UUID id;
	private String accountID;
	@Setter
	private Timestamp deleted;


}
