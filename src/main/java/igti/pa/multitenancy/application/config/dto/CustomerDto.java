

package igti.pa.multitenancy.application.config.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDto {

    private final Integer id;

    private final String firstName;

    private final String lastName;

    @JsonCreator
    public CustomerDto(@JsonProperty("id") Integer id,
                       @JsonProperty("firstName") String firstName,
                       @JsonProperty("lastName") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }
}