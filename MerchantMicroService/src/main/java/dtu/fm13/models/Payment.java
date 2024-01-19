/*Harald
 */
package dtu.fm13.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private UUID payerToken;
    private UUID merchantId;
    private int amount;
}