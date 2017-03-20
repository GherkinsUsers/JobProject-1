package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.models.Resume;

import java.util.List;

/**
 * Created by AR on 19.03.2017.
 */
public interface ResumeDAO {
    void addResume(Resume Resume);

    void deleteResume(int id_Resume);

    void updateResume(Resume Resume);

    List<Resume> getAllResumes();

    Resume getResumeById(int id_Resume);
}
