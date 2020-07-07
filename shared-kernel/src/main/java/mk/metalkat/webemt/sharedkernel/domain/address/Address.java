package mk.metalkat.webemt.sharedkernel.domain.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import mk.metalkat.webemt.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Embeddable
@MappedSuperclass
@NoArgsConstructor
public class Address implements ValueObject {

    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    @Embedded
    private ContactNumber contactNumber;

    public Address(@NonNull String address, @NonNull ContactNumber contactNumber) {
        this.address = address;
        this.contactNumber = contactNumber;
    }

    @NonNull
    @JsonProperty("address")
    public String address() {
        return address;
    }

    @NonNull
    @JsonProperty("contactNumber")
    public ContactNumber city() {
        return contactNumber;
    }

}
