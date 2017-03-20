package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.models.JobSeeker;

import java.util.List;

/**
 * Created by AR on 19.03.2017.
 */
public interface JobSeekerDAO {

    void addJobSeeker(JobSeeker jobSeeker);

    void deleteJobSeeker(int id_jobSeeker);

    void updateJobSeeker(JobSeeker jobSeeker);

    List<JobSeeker> getAllJobSeekers();

    JobSeeker getJobSeekerById(int id_jobseeker);

}
