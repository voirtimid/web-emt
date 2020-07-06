package mk.metalkat.webemt.jobmanagement.domain.repository;

import mk.metalkat.webemt.jobmanagement.domain.model.Job;
import mk.metalkat.webemt.jobmanagement.domain.model.JobId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, JobId> {
}
