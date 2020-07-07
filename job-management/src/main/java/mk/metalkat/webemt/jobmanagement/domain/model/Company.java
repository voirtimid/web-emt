package mk.metalkat.webemt.jobmanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import mk.metalkat.webemt.sharedkernel.domain.address.Address;
import mk.metalkat.webemt.sharedkernel.domain.address.ContactNumber;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Company extends Address {

    @Column(name = "company_name")
    private String name;

    public Company(String name, String address, ContactNumber number) {
        super(address, number);
        this.name = name;
    }

    @NonNull
    @JsonProperty("name")
    public String name() {
        return name;
    }
}
