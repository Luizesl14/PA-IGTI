
package igti.pa.multitenancy.infraestructure.resource;

import igti.pa.multitenancy.application.core.simulation.SimulationService;
import igti.pa.multitenancy.domain.model.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulation")
public class SimulationResource {

    @Autowired
    private SimulationService simulationService;


    @GetMapping
    public ResponseEntity<List<Simulation>> getAll() {
        return ResponseEntity.ok(this.simulationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Simulation> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.simulationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Simulation> post(@RequestBody Simulation simulation) {
       return ResponseEntity.ok(this.simulationService.save(simulation));
    }

    @PutMapping
    public ResponseEntity<Simulation> put(@RequestBody Simulation simulation) {
        return ResponseEntity.ok(this.simulationService.save(simulation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        this.simulationService.delete(id);
        return ResponseEntity.ok().build();
    }

}
