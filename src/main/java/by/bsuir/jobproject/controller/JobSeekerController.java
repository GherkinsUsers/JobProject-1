package by.bsuir.jobproject.controller;

import by.bsuir.jobproject.dao.JobSeekerDAOImpl;
import by.bsuir.jobproject.model.JobSeeker;

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

    private static final String ACTION_DELETE = "delete";
    private static final String ACTION_EDIT = "edit";
    private static final String ACTION_LIST_VIEW = "list";
    private static final String ACTION_INSERT = "insert";

    public JobSeekerController() {
        dao = new JobSeekerDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase(ACTION_DELETE)) {
            int jobseeker_id = Integer.parseInt(request.getParameter("jobseeker_id"));
            dao.deleteJobSeeker(jobseeker_id);
            forward = LIST_JOBSEEKERS;
            request.setAttribute("jobSeekers", dao.getAllJobSeekers());
        } else if (action.equalsIgnoreCase(ACTION_EDIT)) {
            forward = INSERT_OR_EDIT;
            int jobseeker_id = Integer.parseInt(request.getParameter("jobseeker_id"));
            JobSeeker jobSeeker = dao.getJobSeekerById(jobseeker_id);
            request.setAttribute("jobSeeker", jobSeeker);
        } else if (action.equalsIgnoreCase(ACTION_LIST_VIEW)) {
            forward = LIST_JOBSEEKERS;
            request.setAttribute("jobSeekers", dao.getAllJobSeekers());
        } else if (action.equalsIgnoreCase(ACTION_INSERT)) {
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
        request.setAttribute("jobSeekers", dao.getAllJobSeekers());

        String jobseeker_id = request.getParameter("jobseeker_id");
        if (jobseeker_id == null | jobseeker_id == "") {
            dao.addJobSeeker(jobSeeker);
        } else {
            jobSeeker.setJobseeker_id(Integer.parseInt(jobseeker_id));
            dao.updateJobSeeker(jobSeeker);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_JOBSEEKERS);
        view.forward(request, response);
    }

}