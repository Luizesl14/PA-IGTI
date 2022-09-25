package igti.pa.multitenancy.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "number")
    private Integer number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "property_type")
    private PropertyType propertyType;

    @Column(name = "property_paid_off")
    private Boolean propertyPaidOff;

}
