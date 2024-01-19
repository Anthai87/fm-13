package dtu.fm13.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String token, payerId, recieverId;
    private int amount;


}