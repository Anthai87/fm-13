/* Anthony
 */
package dtu.fm13.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Customer {
	private UUID id;
    private String accountID;
    private String cpr;
    private String firstName;
    private String lastName;

    public Customer(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(accountID, customer.getAccountID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }



}
