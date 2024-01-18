package dtu.fm13.Payment.models;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenRequest {
    String userid;
    UUID token;
}
