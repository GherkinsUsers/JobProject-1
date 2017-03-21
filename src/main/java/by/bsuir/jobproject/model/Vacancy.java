package by.bsuir.jobproject.model;

import java.io.Serializable;

/**
 * Created by AR on 17.03.2017.
 */
public class Vacancy implements Serializable {
    private int id_vacancy;
    private int id_profession;
    private int id_company;
    private int id_position;
    private String vacancy_name;
    private String vacancy_requirements;
    private String vacancy_payment;


    public int getId_vacancy() {
        return id_vacancy;
    }

    public void setId_vacancy(int id_vacancy) {
        this.id_vacancy = id_vacancy;
    }

    public int getId_profession() {
        return id_profession;
    }

    public void setId_profession(int id_profession) {
        this.id_profession = id_profession;
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public int getId_position() {
        return id_position;
    }

    public void setId_position(int id_position) {
        this.id_position = id_position;
    }

    public String getVacancy_name() {
        return vacancy_name;
    }

    public void setVacancy_name(String vacancy_name) {
        this.vacancy_name = vacancy_name;
    }

    public String getVacancy_requirements() {
        return vacancy_requirements;
    }

    public void setVacancy_requirements(String vacancy_requirements) {
        this.vacancy_requirements = vacancy_requirements;
    }

    public String getVacancy_payment() {
        return vacancy_payment;
    }

    public void setVacancy_payment(String vacancy_payment) {
        this.vacancy_payment = vacancy_payment;
    }
}
