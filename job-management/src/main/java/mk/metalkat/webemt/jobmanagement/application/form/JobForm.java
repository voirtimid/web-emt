package mk.metalkat.webemt.jobmanagement.application.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import mk.metalkat.webemt.jobmanagement.domain.model.EmployeeId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class JobForm implements Serializable {

    @NonNull
    private EmployeeId employeeId;

    private List<JobEntryForm> jobEntries = new ArrayList<>();

    private CompanyForm companyForm;
}
