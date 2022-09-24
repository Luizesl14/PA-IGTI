package igti.pa.multitenancy.application.config.keycloak;


import igti.pa.multitenancy.application.core.keycloak.TokenDto;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@FeignClient(name = "authentication", url ="localhost:8080/realms/master")
public interface Ikeycloak {

    @CollectionFormat(feign.CollectionFormat.CSV)
    @GetMapping
    ResponseEntity<?> findAll(@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize);

    @PostMapping(value = "/protocol/openid-connect/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenDto token(@RequestBody Map<String, ?> form);


    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}