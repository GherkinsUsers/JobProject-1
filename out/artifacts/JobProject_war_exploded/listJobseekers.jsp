<%--
  Created by IntelliJ IDEA.
  User: AR
  Date: 12.03.2017
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All JobSeekers</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>JobSeeker ID</th>
                <th>JobSeeker Last Name</th>
                <th>JobSeeker Name</th>
                <th>JobSeeker Login</th>
                <th>JobSeeker Password</th>
                <th>JobSeeker Email</th>
                <th>JobSeeker Status</th>
            </tr>
        </thead>
        <tbody>
            <%--@elvariable id="jobSeekers" type="java.util.List"--%>
            <c:forEach items="${jobSeekers}" var="jobSeeker">
                <tr>
                    <td><c:out value="${jobSeeker.id_jobseeker}" /></td>
                    <td><c:out value="${jobSeeker.jobseeker_lastname}" /></td>
                    <td><c:out value="${jobSeeker.jobseeker_name}" /></td>
                    <td><c:out value="${jobSeeker.jobseeker_login}" /></td>
                    <td><c:out value="${jobSeeker.jobseeker_password}" /></td>
                    <td><c:out value="${jobSeeker.jobseeker_email}" /></td>
                    <td><c:out value="${jobSeeker.jobseeker_status}" /></td>
                    <td><a href="JobSeekerController?action=edit&id_jobseeker=<c:out value="${jobSeeker.id_jobseeker}"/>">Update</a></td>
                    <td><a href="JobSeekerController?action=delete&id_jobseeker=<c:out value="${jobSeeker.id_jobseeker}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
     </table>
    <p><a href="JobSeekerController?action=insert">Add JobSeeker</a></p>
 </body>
 </html>