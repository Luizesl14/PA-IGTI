package igti.pa.multitenancy.domain.model;

import lombok.Getter;

@Getter
public enum ProfessionalSituationType {

    SALARIED("Assalariado"),
    LIBERAL_PROFESSIONAL("Profissional Liberal"),
    BUSINESSPERSON("Empresário");

    private String desc;

    ProfessionalSituationType(String desc) {
        this.desc = desc;
    }
}
