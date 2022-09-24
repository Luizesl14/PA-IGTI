
package igti.pa.multitenancy.infraestructure.repository;

import igti.pa.multitenancy.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
