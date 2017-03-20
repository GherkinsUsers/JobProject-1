package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.models.JobSeeker;
import by.bsuir.jobproject.util.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AR on 12.03.2017.
 */
public class JobSeekerDAOImpl extends DAO implements JobSeekerDAO {
//конст
    public void addJobSeeker(JobSeeker jobSeeker) {
        try {
            String query = "insert into jobseeker (jobseeker_lastname, jobseeker_name, jobseeker_login, jobseeker_password, jobseeker_email, jobseeker_status) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = DAO.getConnection().prepareStatement(query);

            preparedStatement.setString(1, jobSeeker.getJobseeker_lastname());
            preparedStatement.setString(2, jobSeeker.getJobseeker_name());
            preparedStatement.setString(3, jobSeeker.getJobseeker_login());
            preparedStatement.setString(4, jobSeeker.getJobseeker_password());
            preparedStatement.setString(5, jobSeeker.getJobseeker_email());
            preparedStatement.setString(6, jobSeeker.getJobseeker_status());

            preparedStatement.executeUpdate();
            preparedStatement.close();//finally
        } catch (SQLException e) {
            e.printStackTrace();//выше
        }
    }

    public void deleteJobSeeker(int id_jobSeeker) {

        try {
            PreparedStatement preparedStatement =
                    DAO.getConnection().prepareStatement("delete from jobseeker where id_jobseeker=?");
            preparedStatement.setInt(1, id_jobSeeker);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateJobSeeker(JobSeeker jobSeeker) {
        try {
            String query = "update jobseeker set jobseeker_lastname=?, jobseeker_name=?, jobseeker_login=?, jobseeker_password=?, jobseeker_email=?, jobseeker_status=? where id_jobseeker=?";
            PreparedStatement preparedStatement = DAO.getConnection().prepareStatement(query);

            preparedStatement.setString(1, jobSeeker.getJobseeker_lastname());
            preparedStatement.setString(2, jobSeeker.getJobseeker_name());
            preparedStatement.setString(3, jobSeeker.getJobseeker_login());//Возможно удалить
            preparedStatement.setString(4, jobSeeker.getJobseeker_password());
            preparedStatement.setString(5, jobSeeker.getJobseeker_email());
            preparedStatement.setString(6, jobSeeker.getJobseeker_status());
            preparedStatement.setInt(7, jobSeeker.getId_jobseeker());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<JobSeeker> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = new ArrayList<JobSeeker>();
        try {
            Statement statement = DAO.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select id_jobseeker,jobseeker_lastname,jobseeker_name,jobseeker_login,jobseeker_password,jobseeker_email,jobseeker_status from jobseeker");
            while (resultSet.next()) {
                JobSeeker jobSeeker = new JobSeeker();
                jobSeeker.setId_jobseeker(resultSet.getInt("id_jobseeker"));
                jobSeeker.setJobseeker_lastname(resultSet.getString("jobseeker_lastname"));
                jobSeeker.setJobseeker_name(resultSet.getString("jobseeker_name"));
                jobSeeker.setJobseeker_login(resultSet.getString("jobseeker_login"));
                jobSeeker.setJobseeker_password(resultSet.getString("jobseeker_password"));
                jobSeeker.setJobseeker_email(resultSet.getString("jobseeker_email"));
                jobSeeker.setJobseeker_status(resultSet.getString("jobseeker_status"));
                jobSeekers.add(jobSeeker);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobSeekers;
    }

    public JobSeeker getJobSeekerById(int id_jobseeker) {
        JobSeeker jobSeeker = new JobSeeker();
        try {
            PreparedStatement preparedStatement = DAO.getConnection().
                    prepareStatement("select * from jobseeker where id_jobseeker=?");
            preparedStatement.setInt(1, id_jobseeker);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                jobSeeker.setId_jobseeker(resultSet.getInt("id_jobseeker"));
                jobSeeker.setJobseeker_lastname(resultSet.getString("jobseeker_lastname"));
                jobSeeker.setJobseeker_name(resultSet.getString("jobseeker_name"));
                jobSeeker.setJobseeker_login(resultSet.getString("jobseeker_login"));
                jobSeeker.setJobseeker_password(resultSet.getString("jobseeker_password"));
                jobSeeker.setJobseeker_email(resultSet.getString("jobseeker_email"));
                jobSeeker.setJobseeker_status(resultSet.getString("jobseeker_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobSeeker;
    }
}