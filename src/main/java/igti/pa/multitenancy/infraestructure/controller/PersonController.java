
package igti.pa.multitenancy.infraestructure.controller;

import igti.pa.multitenancy.application.core.person.PersonService;
import igti.pa.multitenancy.domain.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(this.personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> post(@RequestBody Person person) {
       return ResponseEntity.ok(this.personService.save(person));
    }

    @PutMapping
    public ResponseEntity<Person> put(@RequestBody Person person) {
        return ResponseEntity.ok(this.personService.save(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        this.personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
