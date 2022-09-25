package igti.pa.multitenancy.application.core.keycloak;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {
    private String access_token;
    private String token_type;
    private String scope;
}
