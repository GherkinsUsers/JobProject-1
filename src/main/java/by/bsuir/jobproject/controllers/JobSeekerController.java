package by.bsuir.jobproject.controllers;

import by.bsuir.jobproject.dao.JobSeekerDAOImpl;
import by.bsuir.jobproject.models.JobSeeker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by AR on 12.03.2017.
 */

@WebServlet(urlPatterns = {"/JobSeekerController"})
public class JobSeekerController extends HttpServlet {

    private static JobSeekerDAOImpl dao;
    private static final long serialVersionUID = 1L;
    private static final String LIST_JOBSEEKERS = "/listJobSeekers.jsp";
    private static final String INSERT_OR_EDIT = "/edtJobSeeker.jsp";

    public JobSeekerController() {
        dao = new JobSeekerDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            int id_jobseeker = Integer.parseInt(request.getParameter("id_jobseeker"));
            dao.deleteJobSeeker(id_jobseeker);
            forward = LIST_JOBSEEKERS;
            request.setAttribute("jobSeekers", dao.getAllJobSeekers());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id_jobseeker = Integer.parseInt(request.getParameter("id_jobseeker"));
            JobSeeker jobSeeker = dao.getJobSeekerById(id_jobseeker);
            request.setAttribute("jobSeeker", jobSeeker);
        } else if (action.equalsIgnoreCase("list")) {
            forward = LIST_JOBSEEKERS;
            request.setAttribute("jobSeekers", dao.getAllJobSeekers());
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        }
        //doget dopost - final, protected abstract - execute

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobSeeker jobSeeker = new JobSeeker();

        jobSeeker.setJobseeker_lastname(request.getParameter("jobseeker_lastname"));
        jobSeeker.setJobseeker_name(request.getParameter("jobseeker_name"));
        jobSeeker.setJobseeker_login(request.getParameter("jobseeker_login"));
        jobSeeker.setJobseeker_password(request.getParameter("jobseeker_password"));
        jobSeeker.setJobseeker_email(request.getParameter("jobseeker_email"));
        jobSeeker.setJobseeker_status(request.getParameter("jobseeker_status"));

        String id_jobseeker = request.getParameter("id_jobseeker");
        if (id_jobseeker == null | id_jobseeker == "") {
            dao.addJobSeeker(jobSeeker);
        } else {
            jobSeeker.setId_jobseeker(Integer.parseInt(id_jobseeker));
            dao.updateJobSeeker(jobSeeker);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_JOBSEEKERS);
        request.setAttribute("jobSeekers", dao.getAllJobSeekers());
        view.forward(request, response);
    }

}