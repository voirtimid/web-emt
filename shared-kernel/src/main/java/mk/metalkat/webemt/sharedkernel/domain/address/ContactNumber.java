package mk.metalkat.webemt.sharedkernel.domain.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.NoArgsConstructor;
import mk.metalkat.webemt.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Value object representing the contact numbers of a company.
 */
@Embeddable
@NoArgsConstructor
public class ContactNumber implements ValueObject {

    @Column(name = "contact_number")
    private String number;

    @JsonCreator
    public ContactNumber(@NonNull String number) {
        this.number = Objects.requireNonNull(number, "number must not be null");
    }
}
