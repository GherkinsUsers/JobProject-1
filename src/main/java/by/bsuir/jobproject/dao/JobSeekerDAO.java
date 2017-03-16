package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.models.JobSeeker;
import by.bsuir.jobproject.util.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AR on 12.03.2017.
 */
public class JobSeekerDAO extends DAO {

    public List<JobSeeker> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = new ArrayList<JobSeeker>();
        try {
            Statement statement = DAO.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select id_jobseeker,jobseeker_lastname,jobseeker_name,jobseeker_login,jobseeker_password,jobseeker_email from jobseeker");
            while (resultSet.next()) {
                JobSeeker jobSeeker = new JobSeeker();
                jobSeeker.setId_jobseeker(resultSet.getInt("id_jobseeker"));
                jobSeeker.setJobseeker_lastname(resultSet.getString("jobseeker_lastname"));
                jobSeeker.setJobseeker_name(resultSet.getString("jobseeker_name"));
                jobSeeker.setJobseeker_login(resultSet.getString("jobseeker_login"));
                jobSeeker.setJobseeker_password(resultSet.getString("jobseeker_password"));
                jobSeeker.setJobseeker_email(resultSet.getString("jobseeker_email"));
                jobSeekers.add(jobSeeker);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobSeekers;
    }



}