package mk.metalkat.webemt.jobmanagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Task {

    private TaskId taskId;

    private String remark;

    private Long trackedTime;
}
