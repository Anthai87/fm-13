/*Harald
 */
package dtu.fm13.Payment.models;

import java.security.Timestamp;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
	private UUID id;
	private String accountID;
	private Timestamp deleted;
}
