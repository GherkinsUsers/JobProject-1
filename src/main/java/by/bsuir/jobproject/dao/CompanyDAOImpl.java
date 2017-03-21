package by.bsuir.jobproject.dao;

import by.bsuir.jobproject.model.Company;
import by.bsuir.jobproject.util.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AR on 19.03.2017.
 */
//TODO rename id
public class CompanyDAOImpl extends DAO implements CompanyDAO {

    public void addCompany(Company company) {
        try {
            String query = "insert into company (id_country, company_name, company_staff, company_information, company_website) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);

            preparedStatement.setInt(1, company.getId_country());
            preparedStatement.setString(2, company.getCompany_name());
            preparedStatement.setString(3, company.getCompany_staff());
            preparedStatement.setString(4, company.getCompany_information());
            preparedStatement.setString(5, company.getCompany_website());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany(int id_company) {
        try {
            PreparedStatement preparedStatement =
                    getConnection().prepareStatement("delete from company where id_company=?");

            preparedStatement.setInt(1, id_company);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCompany(Company company) {
        try {
            String query = "update company set id_country=?, company_name=?, company_staff=?, company_information=?, company_website=? where id_company=?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);

            preparedStatement.setInt(1, company.getId_country());
            preparedStatement.setString(2, company.getCompany_name());
            preparedStatement.setString(3, company.getCompany_staff());//Возможно удалить
            preparedStatement.setString(4, company.getCompany_information());
            preparedStatement.setString(5, company.getCompany_website());
            preparedStatement.setInt(6, company.getId_company());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select id_company, id_country, company_name, company_staff, company_information, company_website from company");
            while (resultSet.next()) {
                Company company = new Company();
                company.setId_company(resultSet.getInt("id_company"));
                company.setId_country(resultSet.getInt("id_country"));
                company.setCompany_name(resultSet.getString("company_name"));
                company.setCompany_staff(resultSet.getString("company_staff"));
                company.setCompany_information(resultSet.getString("company_information"));
                company.setCompany_website(resultSet.getString("company_website"));
                companies.add(company);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    public Company getCompanyById(int id_company) {
        Company company = new Company();
        try {
            PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from company where id_company=?");
            preparedStatement.setInt(1, id_company);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                company.setId_company(resultSet.getInt("id_company"));
                company.setId_country(resultSet.getInt("id_country"));
                company.setCompany_name(resultSet.getString("company_name"));
                company.setCompany_staff(resultSet.getString("company_staff"));
                company.setCompany_information(resultSet.getString("company_information"));
                company.setCompany_website(resultSet.getString("company_website"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return company;
    }
}
