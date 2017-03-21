<%--
  Created by IntelliJ IDEA.
  User: AR
  Date: 19.03.2017
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Add New JobSeekers</title>
</head>
<body>
    <form method="post" action="JobSeekerController">
        <%--@elvariable id="jobSeeker" type=""--%>
        JobSeeker ID : <label>
        <input
                type="text" readonly="readonly" name="jobseeker_id"
                value="<c:out value="${jobSeeker.jobseeker_id}" />"/>
        </label> <br/>

        JobSeeker Last Name : <label>
        <input
                type="text" name="jobseeker_lastname"
                value="<c:out value="${jobSeeker.jobseeker_lastname}" />"/>
        </label> <br/>

        JobSeeker Name: <label>
        <input
                type="text" name="jobseeker_name"
                value="<c:out value="${jobSeeker.jobseeker_name}" />"/>
        </label> <br/>

        JobSeeker Login: <label>
        <input
                type="text" name="jobseeker_login"
                value="<c:out value="${jobSeeker.jobseeker_login}" />"/>
        </label> <br/>

        JobSeeker Password: <label>
        <input
                type="text" name="jobseeker_password"
                value="<c:out value="${jobSeeker.jobseeker_password}" />"/>
        </label> <br/>

        JobSeeker Email: <label>
        <input
                type="text" name="jobseeker_email"
                value="<c:out value="${jobSeeker.jobseeker_email}" />"/>
        </label> <br/>

        JobSeeker Status: <label>
        <input
                type="text" name="jobseeker_status"
                value="<c:out value="${jobSeeker.jobseeker_status}" />"/>
        </label> <br/>

        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
