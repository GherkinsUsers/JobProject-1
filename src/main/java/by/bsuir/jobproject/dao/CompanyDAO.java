package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.model.Company;

import java.util.List;

/**
 * Created by AR on 19.03.2017.
 */
//TODO rename id
public interface CompanyDAO {

    void addCompany(Company company);

    void deleteCompany(int id_company);

    void updateCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(int id_company);

}
