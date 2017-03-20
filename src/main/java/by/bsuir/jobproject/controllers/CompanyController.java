package by.bsuir.jobproject.controllers;

import by.bsuir.jobproject.dao.CompanyDAOImpl;
import by.bsuir.jobproject.models.Company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AR on 19.03.2017.
 */

@WebServlet(urlPatterns = {"/CompanyController"})
public class CompanyController extends HttpServlet {

    private static CompanyDAOImpl dao;
    private static final long serialVersionUID = 1L;
    private static final String LIST_COMPANIES = "/listCompanies.jsp";
    private static final String INSERT_OR_EDIT = "/edtCompany.jsp";

    public CompanyController() {
        dao = new CompanyDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            int id_company = Integer.parseInt(request.getParameter("id_company"));
            dao.deleteCompany(id_company);
            forward = LIST_COMPANIES;
            request.setAttribute("companies", dao.getAllCompanies());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id_company = Integer.parseInt(request.getParameter("id_company"));
            Company company = dao.getCompanyById(id_company);
            request.setAttribute("company", company);
        } else if (action.equalsIgnoreCase("list")) {
            forward = LIST_COMPANIES;
            request.setAttribute("companies", dao.getAllCompanies());
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Company company = new Company();

        company.setId_country(Integer.parseInt(request.getParameter("id_country")));
        company.setCompany_name(request.getParameter("company_name"));
        company.setCompany_staff(request.getParameter("company_staff"));
        company.setCompany_information(request.getParameter("company_information"));
        company.setCompany_website(request.getParameter("company_website"));


        String id_company = request.getParameter("id_company");
        if (id_company == null | id_company == "") {
            dao.addCompany(company);
        } else {
            company.setId_company(Integer.parseInt(id_company));
            dao.updateCompany(company);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_COMPANIES);
        request.setAttribute("companies", dao.getAllCompanies());
        view.forward(request, response);
    }

}
