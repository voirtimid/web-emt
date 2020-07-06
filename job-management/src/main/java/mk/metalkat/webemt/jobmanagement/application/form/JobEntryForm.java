package mk.metalkat.webemt.jobmanagement.application.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mk.metalkat.webemt.jobmanagement.domain.model.Task;

import java.io.Serializable;

@Getter
public class JobEntryForm implements Serializable {

    private Task task;
}
