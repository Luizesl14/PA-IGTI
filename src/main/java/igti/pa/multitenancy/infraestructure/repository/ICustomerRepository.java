
package igti.pa.multitenancy.infraestructure.repository;

import igti.pa.multitenancy.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Async
    @Query("select c from Customer c")
    CompletableFuture<List<Customer>> findAllAsync();

}
