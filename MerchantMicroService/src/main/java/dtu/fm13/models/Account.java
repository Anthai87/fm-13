/*Elias
 */
package dtu.fm13.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Account {
	private UUID id;
    private String accountID;
    private String cpr;
    private String firstName;
    private String lastName;

    public Account(String name, String address) {
        this.firstName = name;
        this.lastName = address;
    }

	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account customer = (Account) o;
        return Objects.equals(id, customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }



}
