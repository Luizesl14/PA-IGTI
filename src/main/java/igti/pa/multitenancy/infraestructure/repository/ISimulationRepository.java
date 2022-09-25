
package igti.pa.multitenancy.infraestructure.repository;

import igti.pa.multitenancy.domain.model.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISimulationRepository extends JpaRepository<Simulation, Integer> {

}
