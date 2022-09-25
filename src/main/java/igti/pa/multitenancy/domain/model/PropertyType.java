package igti.pa.multitenancy.domain.model;

import lombok.Getter;

@Getter
public enum PropertyType {

    RURAL("Imóvel Rural"),
    APARTMENT("Aparteamento"),
    HOUSE("Casa");

    private String desc;

    PropertyType(String desc) {
        this.desc = desc;
    }
}
