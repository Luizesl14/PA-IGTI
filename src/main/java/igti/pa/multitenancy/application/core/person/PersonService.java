package igti.pa.multitenancy.application.core.person;

import igti.pa.multitenancy.domain.model.Person;
import igti.pa.multitenancy.domain.vo.IService;
import igti.pa.multitenancy.infraestructure.repository.IPersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class PersonService implements IService<Person> {

    @Autowired
    private IPersonRepository personRepository;


    @Override
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Person findById(Integer id) {
        return this.personRepository.findById(id)
                .orElseThrow(()-> new EntityExistsException("Entity cod PSA404"));
    }

    @Override
    public Person save(Person person) {
        try {
           return this.personRepository.save(person);
        } catch (Exception e) {
            throw new EntityExistsException(e);
        }
    }

    @Override
    public Person update(Person person) {
        Person personData = this.findById(person.getId());
        BeanUtils.copyProperties(person, personData);
        try {
            return this.personRepository.save(person);
        } catch (Exception e) {
            throw new EntityExistsException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        this.personRepository.deleteById(id);
    }
}
