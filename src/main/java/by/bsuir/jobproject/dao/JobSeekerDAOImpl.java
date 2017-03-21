package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.model.JobSeeker;
import by.bsuir.jobproject.util.DAO;
import by.bsuir.jobproject.util.DAOException;

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
    private static final String COLUMN_JOBSEEKER_ID = "id_jobseeker";
    private static final String COLUMN_JOBSEEKER_LASTNAME = "jobseeker_lastname";
    private static final String COLUMN_JOBSEEKER_NAME = "jobseeker_name";
    private static final String COLUMN_JOBSEEKER_LOGIN = "jobseeker_login";
    private static final String COLUMN_JOBSEEKER_PASSWORD = "jobseeker_password";
    private static final String COLUMN_JOBSEEKER_EMAIL = "jobseeker_email";
    private static final String COLUMN_JOBSEEKER_STATUS = "jobseeker_status";

    private static final String QUERY_ADD_JOBSEEKER = "insert into jobseeker (jobseeker_lastname, jobseeker_name, jobseeker_login, jobseeker_password, jobseeker_email, jobseeker_status) values (?,?,?,?,?,?)";
    private static final String QUERY_DELETE_JOBSEEKER = "delete from jobseeker where id_jobseeker=?";
    private static final String QUERY_UPDATE_JOBSEEKER = "update jobseeker set jobseeker_lastname=?, jobseeker_name=?, jobseeker_login=?, jobseeker_password=?, jobseeker_email=?, jobseeker_status=? where id_jobseeker=?";
    private static final String QUERY_GET_ALL_JOBSEEKERS = "select id_jobseeker,jobseeker_lastname,jobseeker_name,jobseeker_login,jobseeker_password,jobseeker_email,jobseeker_status from jobseeker";
    private static final String QUERY_GET_JOBSEEKER = "select id_jobseeker,jobseeker_lastname,jobseeker_name,jobseeker_login,jobseeker_password,jobseeker_email,jobseeker_status from jobseeker where id_jobseeker=?";

    public void addJobSeeker(JobSeeker jobSeeker) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(QUERY_ADD_JOBSEEKER);

            preparedStatement.setString(1, jobSeeker.getJobseeker_lastname());
            preparedStatement.setString(2, jobSeeker.getJobseeker_name());
            preparedStatement.setString(3, jobSeeker.getJobseeker_login());
            preparedStatement.setString(4, jobSeeker.getJobseeker_password());
            preparedStatement.setString(5, jobSeeker.getJobseeker_email());
            preparedStatement.setString(6, jobSeeker.getJobseeker_status());
            preparedStatement.executeUpdate();
            //finally
        } catch (SQLException e) {
            throw new DAOException(e);//выше
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void deleteJobSeeker(int jobseeker_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    getConnection().prepareStatement(QUERY_DELETE_JOBSEEKER);
            preparedStatement.setInt(1, jobseeker_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateJobSeeker(JobSeeker jobSeeker) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(QUERY_UPDATE_JOBSEEKER);

            preparedStatement.setString(1, jobSeeker.getJobseeker_lastname());
            preparedStatement.setString(2, jobSeeker.getJobseeker_name());
            preparedStatement.setString(3, jobSeeker.getJobseeker_login());//Возможно удалить
            preparedStatement.setString(4, jobSeeker.getJobseeker_password());
            preparedStatement.setString(5, jobSeeker.getJobseeker_email());
            preparedStatement.setString(6, jobSeeker.getJobseeker_status());
            preparedStatement.setInt(7, jobSeeker.getJobseeker_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<JobSeeker> getAllJobSeekers() throws DAOException {
        List<JobSeeker> jobSeekers = new ArrayList<JobSeeker>();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(QUERY_GET_ALL_JOBSEEKERS);
            while (resultSet.next()) {
                JobSeeker jobSeeker = new JobSeeker();
                jobSeeker.setJobseeker_id(resultSet.getInt(COLUMN_JOBSEEKER_ID));
                jobSeeker.setJobseeker_lastname(resultSet.getString(COLUMN_JOBSEEKER_LASTNAME));
                jobSeeker.setJobseeker_name(resultSet.getString(COLUMN_JOBSEEKER_NAME));
                jobSeeker.setJobseeker_login(resultSet.getString(COLUMN_JOBSEEKER_LOGIN));
                jobSeeker.setJobseeker_password(resultSet.getString(COLUMN_JOBSEEKER_PASSWORD));
                jobSeeker.setJobseeker_email(resultSet.getString(COLUMN_JOBSEEKER_EMAIL));
                jobSeeker.setJobseeker_status(resultSet.getString(COLUMN_JOBSEEKER_STATUS));
                jobSeekers.add(jobSeeker);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return jobSeekers;
    }

    public JobSeeker getJobSeekerById(int jobseeker_id) throws DAOException {
        JobSeeker jobSeeker = new JobSeeker();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(QUERY_GET_JOBSEEKER);
            preparedStatement.setInt(1, jobseeker_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                jobSeeker.setJobseeker_id(resultSet.getInt(COLUMN_JOBSEEKER_ID));
                jobSeeker.setJobseeker_lastname(resultSet.getString(COLUMN_JOBSEEKER_LASTNAME));
                jobSeeker.setJobseeker_name(resultSet.getString(COLUMN_JOBSEEKER_NAME));
                jobSeeker.setJobseeker_login(resultSet.getString(COLUMN_JOBSEEKER_LOGIN));
                jobSeeker.setJobseeker_password(resultSet.getString(COLUMN_JOBSEEKER_PASSWORD));
                jobSeeker.setJobseeker_email(resultSet.getString(COLUMN_JOBSEEKER_EMAIL));
                jobSeeker.setJobseeker_status(resultSet.getString(COLUMN_JOBSEEKER_STATUS));
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jobSeeker;
    }
}