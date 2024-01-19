/*Harald
 */
package dtu.fm13.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CustomerFromInterface {

	private UUID dTUPayID;
	private String cpr;
	private String firstName;
	private String lastName;

	public CustomerFromInterface(String name, String address) {
		this.firstName = name;
		this.lastName = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomerFromInterface customer = (CustomerFromInterface) o;
		return Objects.equals(dTUPayID, customer.dTUPayID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dTUPayID);
	}
}
