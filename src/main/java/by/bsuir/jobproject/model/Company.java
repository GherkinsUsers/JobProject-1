package by.bsuir.jobproject.model;

import java.io.Serializable;

/**
 * Created by AR on 19.03.2017.
 */
public class Company implements Serializable {

    private int id_company;
    private int id_country;
    private String company_name;
    private String company_staff;
    private String company_information;
    private String company_website;


    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_staff() {
        return company_staff;
    }

    public void setCompany_staff(String company_staff) {
        this.company_staff = company_staff;
    }

    public String getCompany_information() {
        return company_information;
    }

    public void setCompany_information(String company_information) {
        this.company_information = company_information;
    }

    public String getCompany_website() {
        return company_website;
    }

    public void setCompany_website(String company_website) {
        this.company_website = company_website;
    }
}
