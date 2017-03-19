package by.bsuir.jobproject.models;

import java.io.Serializable;

/**
 * Created by AR on 19.03.2017.
 */
public class Resume implements Serializable{
    private int id_resume;
    private int id_applicant;
    private int id_specialty;
    private int id_skill;
    private int id_certificate;
    private int id_country;

    private String resume_jobseeker_fullname;
    private String resume_information;

    public int getId_resume() {
        return id_resume;
    }

    public void setId_resume(int id_resume) {
        this.id_resume = id_resume;
    }

    public int getId_applicant() {
        return id_applicant;
    }

    public void setId_applicant(int id_applicant) {
        this.id_applicant = id_applicant;
    }

    public int getId_specialty() {
        return id_specialty;
    }

    public void setId_specialty(int id_specialty) {
        this.id_specialty = id_specialty;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public int getId_certificate() {
        return id_certificate;
    }

    public void setId_certificate(int id_certificate) {
        this.id_certificate = id_certificate;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public String getResume_jobseeker_fullname() {
        return resume_jobseeker_fullname;
    }

    public void setResume_jobseeker_fullname(String resume_jobseeker_fullname) {
        this.resume_jobseeker_fullname = resume_jobseeker_fullname;
    }

    public String getResume_information() {
        return resume_information;
    }

    public void setResume_information(String resume_information) {
        this.resume_information = resume_information;
    }
}
