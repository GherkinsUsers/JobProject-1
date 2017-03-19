package by.bsuir.jobproject.controllers;

import by.bsuir.jobproject.dao.JobSeekerDAO;
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

@WebServlet(urlPatterns={"/JobSeekerController"})
public class JobSeekerController extends HttpServlet {

    private static JobSeekerDAO dao;
    private static final long serialVersionUID = 1L;
    private static final String LIST_JOBSEEKERS = "/listJobSeekers.jsp";

    public JobSeekerController() {
        dao = new JobSeekerDAO();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("list")) {
            forward = LIST_JOBSEEKERS;
            request.setAttribute("jobSeekers", dao.getAllJobSeekers());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobSeeker jobSeeker = new JobSeeker();

        jobSeeker.setId_jobseeker(Integer.parseInt(request.getParameter("id_jobseeker")));
        jobSeeker.setJobseeker_lastname(request.getParameter("jobseeker_lastname"));
        jobSeeker.setJobseeker_name(request.getParameter("jobseeker_name"));
        jobSeeker.setJobseeker_login(request.getParameter("jobseeker_login"));
        jobSeeker.setJobseeker_password(request.getParameter("jobseeker_password"));
        jobSeeker.setJobseeker_email(request.getParameter("jobseeker_email"));
        jobSeeker.setJobseeker_status(request.getParameter("jobseeker_status"));

        RequestDispatcher view = request.getRequestDispatcher(LIST_JOBSEEKERS);
        request.setAttribute("jobSeekers", dao.getAllJobSeekers());
        view.forward(request, response);
    }


}