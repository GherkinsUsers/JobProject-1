package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.models.Resume;
import by.bsuir.jobproject.util.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by AR on 19.03.2017.
 */
public class ResumeDAOImpl extends DAO implements ResumeDAO {


    public void addResume(Resume resume) {
        try {
            String query = "insert into resume (id_resume, id_jobseeker, id_specialty, id_skill, id_certificate, id_country, resume_information) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = DAO.getConnection().prepareStatement(query);

            preparedStatement.setInt(1, resume.getId_resume());
            preparedStatement.setInt(2, resume.getId_jobseeker());
            preparedStatement.setInt(3, resume.getId_specialty());
            preparedStatement.setInt(4, resume.getId_skill());
            preparedStatement.setInt(5, resume.getId_certificate());
            preparedStatement.setInt(6, resume.getId_country());
            preparedStatement.setString(7, resume.getResume_information());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO check sql
    public void deleteResume(int id_jobSeeker) {

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

    public void updateResume(Resume jobSeeker) {

    }

    public List<Resume> getAllResumes() {
        return null;
    }

    public Resume getResumeById(int id_jobseeker) {
        return null;
    }
}
