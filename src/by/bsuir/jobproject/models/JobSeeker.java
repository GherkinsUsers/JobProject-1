package by.bsuir.jobproject.models;

/**
 * Created by AR on 12.03.2017.
 */
public class JobSeeker {

    private int jobseeker_id;
    private String jobseeker_lastName;
    private String jobseeker_name;
    private String jobseeker_login;
    private String jobseeker_password;
    private String jobseeker_email;

    public int getJobseeker_id() {
        return jobseeker_id;
    }

    public void setJobseeker_id(int jobseeker_id) {
        this.jobseeker_id = jobseeker_id;
    }

    public String getJobseeker_lastName() {
        return jobseeker_lastName;
    }

    public void setJobseeker_lastName(String jobseeker_lastName) {
        this.jobseeker_lastName = jobseeker_lastName;
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

    @Override
    public String toString() {
        return "JobSeeker [jobseekerId=" + jobseeker_id + ", lastName=" + jobseeker_lastName + ", name=" + jobseeker_name
                + ", login=" + jobseeker_login + ", password=" + jobseeker_password + ", email="
                + jobseeker_email + "]";
    }


}
