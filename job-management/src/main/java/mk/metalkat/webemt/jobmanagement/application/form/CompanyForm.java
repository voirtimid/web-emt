package mk.metalkat.webemt.jobmanagement.application.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class CompanyForm implements Serializable {

    private String name;

    private String address;

    private String number;
}
