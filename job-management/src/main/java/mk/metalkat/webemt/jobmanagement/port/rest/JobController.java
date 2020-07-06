package mk.metalkat.webemt.jobmanagement.port.rest;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.jobmanagement.application.JobService;
import mk.metalkat.webemt.jobmanagement.application.form.JobForm;
import mk.metalkat.webemt.jobmanagement.domain.model.Job;
import mk.metalkat.webemt.jobmanagement.domain.model.JobId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<JobId> createJob(@RequestBody JobForm jobForm) {
        JobId jobId = jobService.createJob(jobForm);
        return ResponseEntity.ok(jobId);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAll());
    }
}
