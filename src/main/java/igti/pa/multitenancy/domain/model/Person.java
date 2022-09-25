package igti.pa.multitenancy.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "legal_person")
    private Boolean legalPerson;

    @Column(name = "income")
    private Double income;

    @Enumerated(EnumType.STRING)
    @Column(name = "professional_situation_type")
    private ProfessionalSituationType professionalSituationType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_and_simulation",
            joinColumns = {@JoinColumn(name = "person_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "simulation_id", nullable = false)})
    private List<Simulation> investors;
}
