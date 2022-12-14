
package igti.pa.multitenancy.application.config;


import igti.pa.multitenancy.application.config.dto.CustomerDto;
import igti.pa.multitenancy.domain.model.Customer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Converters {



    private Converters() {

    }

    public static CustomerDto convert(Customer source) {
        if(source == null) {
            return null;
        }

        return new CustomerDto(source.getId(), source.getFirstName(), source.getLastName());
    }

    public static Customer convert(CustomerDto source) {
        if(source == null) {
            return null;
        }

        return new Customer(source.getId(), source.getFirstName(), source.getLastName());
    }

    public static List<CustomerDto> convert(Iterable<Customer> customers) {
        return StreamSupport.stream(customers.spliterator(), false)
                .map(Converters::convert)
                .collect(Collectors.toList());
    }
}
