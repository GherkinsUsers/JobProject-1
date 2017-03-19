package by.bsuir.jobproject.models;

import java.io.Serializable;

/**
 * Created by AR on 12.03.2017.
 */
public class JobSeeker implements Serializable{

    private int id_jobseeker;
    private String jobseeker_lastname;
    private String jobseeker_name;
    private String jobseeker_login;
    private String jobseeker_password;
    private String jobseeker_email;
    private String jobseeker_status;

    public int getId_jobseeker() {
        return id_jobseeker;
    }

    public void setId_jobseeker(int id_jobseeker) {
        this.id_jobseeker = id_jobseeker;
    }

    public String getJobseeker_lastname() {
        return jobseeker_lastname;
    }

    public void setJobseeker_lastname(String jobseeker_lastname) {
        this.jobseeker_lastname = jobseeker_lastname;
    }

    public String getJobseeker_name() {
        return jobseeker_name;
    }

    public void setJobseeker_name(String jobseeker_name) {
        this.jobseeker_name = jobseeker_name;
    }

    public String getJobseeker_login() {
        return jobseeker_login;
    }

    public void setJobseeker_login(String jobseeker_login) {
        this.jobseeker_login = jobseeker_login;
    }

    public String getJobseeker_password() {
        return jobseeker_password;
    }

    public void setJobseeker_password(String jobseeker_password) {
        this.jobseeker_password = jobseeker_password;
    }

    public String getJobseeker_email() {
        return jobseeker_email;
    }

    public void setJobseeker_email(String jobseeker_email) {
        this.jobseeker_email = jobseeker_email;
    }

    public String getJobseeker_status() {
        return jobseeker_status;
    }

    public void setJobseeker_status(String jobseeker_status) {
        this.jobseeker_status = jobseeker_status;
    }
}
