package igti.pa.multitenancy.application.core.keycloak;

import igti.pa.multitenancy.application.config.keycloak.Ikeycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KeycloakService {

    @Autowired
    Ikeycloak ikeycloak;

    public TokenDto getToken(FormDto formDto){
        Map<String, String> form = new HashMap<>();
        form.put("grant_type", formDto.getGrantType());
        form.put("client_id", formDto.getClientId());
        form.put("username", formDto.getUserName());
        form.put("password", formDto.getPassword());
        form.put("scope", formDto.getScope());

        return ikeycloak.token(form);
    }
}
