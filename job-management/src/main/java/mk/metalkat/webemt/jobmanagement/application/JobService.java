package mk.metalkat.webemt.jobmanagement.application;

import lombok.RequiredArgsConstructor;
import mk.metalkat.webemt.jobmanagement.application.form.CompanyForm;
import mk.metalkat.webemt.jobmanagement.application.form.JobForm;
import mk.metalkat.webemt.jobmanagement.domain.event.JobCreated;
import mk.metalkat.webemt.jobmanagement.domain.event.JobEntryAdded;
import mk.metalkat.webemt.jobmanagement.domain.model.Company;
import mk.metalkat.webemt.jobmanagement.domain.model.Job;
import mk.metalkat.webemt.jobmanagement.domain.model.JobId;
import mk.metalkat.webemt.jobmanagement.domain.repository.JobRepository;
import mk.metalkat.webemt.sharedkernel.domain.address.ContactNumber;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final TaskService taskService;

    public JobId createJob(JobForm jobForm) {
        Objects.requireNonNull(jobForm,"job must not be null");

        Job job = jobRepository.saveAndFlush(toDomainModel(jobForm));
        applicationEventPublisher.publishEvent(new JobCreated(job.getCreatedAt(), job.getId(), job.getEmployeeId()));
        job.getJobEntries().forEach(jobEntry -> {
            applicationEventPublisher.publishEvent(new JobEntryAdded(Instant.now(), job.getId(), jobEntry.getId(), job.getEmployeeId(), jobEntry.getTaskId(), jobEntry.getTrackedTime()));
        });

        return job.getId();
    }

    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @NonNull
    private Job toDomainModel(@NonNull JobForm jobForm) {
        Job job = new Job(jobForm.getEmployeeId(), Instant.now(), toDomainModel(jobForm.getCompanyForm()));
        jobForm.getJobEntries().forEach(jobEntryForm -> job.addJobEntry(jobEntryForm.getTask()));
        return job;
    }

    @NonNull
    private Company toDomainModel(@NonNull CompanyForm form) {
        return new Company(form.getName(), form.getAddress(), new ContactNumber(form.getNumber()));
    }

}
