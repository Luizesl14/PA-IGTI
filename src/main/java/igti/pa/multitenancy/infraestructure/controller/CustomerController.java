package igti.pa.multitenancy.infraestructure.controller;

import igti.pa.multitenancy.domain.model.Customer;
import igti.pa.multitenancy.infraestructure.repository.ICustomerRepository;
import igti.pa.multitenancy.application.config.Converters;
import igti.pa.multitenancy.application.config.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerRepository repository;


    @GetMapping("/customers")
    public List<CustomerDto> getAll() {
        Iterable<Customer> customers = repository.findAll();
        return Converters.convert(customers);
    }

    @GetMapping("/customers/{id}")
    public CustomerDto get(@PathVariable("id") Integer id) {
        Customer customer = repository
                .findById(id)
                .orElse(null);
        return Converters.convert(customer);
    }

    @GetMapping("/async/customers")
    public List<CustomerDto> getAllAsync() throws ExecutionException, InterruptedException {
        return repository.findAllAsync()
                .thenApply(Converters::convert)
                .get();
    }

    @PostMapping("/customers")
    public CustomerDto post(@RequestBody CustomerDto customer) {
        Customer source = Converters.convert(customer);
        Customer result = repository.save(source);
        return Converters.convert(result);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

}