package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.model.Resume;

import java.util.List;

/**
 * Created by AR on 19.03.2017.
 */
//TODO rename id
public interface ResumeDAO {
    void addResume(Resume Resume);

    void deleteResume(int id_Resume);

    void updateResume(Resume Resume);

    List<Resume> getAllResumes();

    Resume getResumeById(int id_Resume);
}
