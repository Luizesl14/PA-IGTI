package igti.pa.multitenancy.infraestructure.controller;

import igti.pa.multitenancy.application.core.keycloak.FormDto;
import igti.pa.multitenancy.application.core.keycloak.KeycloakService;
import igti.pa.multitenancy.application.core.keycloak.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

    @Autowired
    private KeycloakService keycloakService;


    @PostMapping("/token")
    public ResponseEntity<TokenDto> token(@RequestBody FormDto form){
        return ResponseEntity.status(HttpStatus.OK).body(this.keycloakService.getToken(form));
    }
}
