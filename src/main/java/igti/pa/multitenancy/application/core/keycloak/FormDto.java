package igti.pa.multitenancy.application.core.keycloak;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormDto {
    private String grantType;
    private String clientId;
    private String userName;
    private String password;
    private String scope;
}
