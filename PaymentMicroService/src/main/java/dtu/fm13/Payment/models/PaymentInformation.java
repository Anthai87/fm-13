package dtu.fm13.Payment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInformation {
    private String token, payerId, recieverId;
    private int amount;


}