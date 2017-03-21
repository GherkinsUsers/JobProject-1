package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.model.JobSeeker;
import by.bsuir.jobproject.util.DAOException;

import java.util.List;

/**
 * Created by AR on 19.03.2017.
 */
public interface JobSeekerDAO {

    void addJobSeeker(JobSeeker jobSeeker) throws DAOException;

    void deleteJobSeeker(int jobseeker_id) throws DAOException;

    void updateJobSeeker(JobSeeker jobSeeker) throws DAOException;

    List<JobSeeker> getAllJobSeekers() throws DAOException;

    JobSeeker getJobSeekerById(int jobseeker_id) throws DAOException;

}
