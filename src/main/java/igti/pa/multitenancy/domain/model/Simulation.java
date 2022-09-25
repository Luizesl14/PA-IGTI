package igti.pa.multitenancy.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "simulation")
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "estimated_value")
    private Double estimatedValue;

    @Column(name = "loan")
    private Double loan;

    @Column(name = "deadline")
    private Integer deadline;

    @Column(name = "reason")
    private String reason;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "simulation_and_property",
            joinColumns = {@JoinColumn(name = "simulation_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "property_id", nullable = false)})
    private List<Property> properties;
}
