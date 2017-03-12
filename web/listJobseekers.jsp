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
    <title>Show All Students</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Jobseeker ID</th>
        <th>Jobseeker Last Name</th>
        <th>Jobseeker Name</th>
        <th>Jobseeker Login</th>
        <th>Jobseeker Password</th>
        <th>Jobseeker Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${jobseekers}" var="jobseeker">
        <tr>
            <td><c:out value="${jobseeker.id_jobseeker}" /></td>
            <td><c:out value="${jobseeker.jobseeker_lastname}" /></td>
            <td><c:out value="${jobseeker.jobseeker_name}" /></td>
            <td><c:out value="${jobseeker.jobseeker_login}" /></td>
            <td><c:out value="${jobseeker.jobseeker_password}" /></td>
            <td><c:out value="${jobseeker.jobseeker_email}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>