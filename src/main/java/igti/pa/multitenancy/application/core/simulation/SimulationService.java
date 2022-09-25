package igti.pa.multitenancy.application.core.simulation;

import igti.pa.multitenancy.domain.model.Simulation;
import igti.pa.multitenancy.domain.vo.IService;
import igti.pa.multitenancy.infraestructure.repository.ISimulationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class SimulationService implements IService<Simulation> {

    @Autowired
    private ISimulationRepository simulationRepository;

    @Override
    public List<Simulation> findAll() {
        return this.simulationRepository.findAll();
    }

    @Override
    public Simulation findById(Integer id) {
        return this.simulationRepository.findById(id)
                .orElseThrow(()-> new EntityExistsException("Entity code SML404"));
    }

    @Override
    public Simulation save(Simulation simulation) {
        try {
            return this.simulationRepository.save(simulation);
        } catch (Exception e) {
            throw new EntityExistsException(e);
        }
    }

    @Override
    public Simulation update(Simulation simulation) {
        Simulation persimulationData = this.findById(simulation.getId());
        BeanUtils.copyProperties(simulation, persimulationData);
        try {
            return this.simulationRepository.save(simulation);
        } catch (Exception e) {
            throw new EntityExistsException(e);
        }
    }

    @Override
    public void delete(Integer id) {
       this.simulationRepository.deleteById(id);
    }
}
