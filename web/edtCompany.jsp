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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add New Company</title>
</head>
<body>

    <form method="post" action="CompanyController">
        <%--@elvariable id="jobSeeker" type=""--%>
            Company ID: <label>
        <input
                type="text" readonly="readonly" name="id_company"
                value="<c:out value="${company.id_company}" />"/>
        </label> <br/>

            Company ID Country: <label>
        <input
                type="text" name="id_country"
                value="<c:out value="${company.id_country}" />"/>
        </label> <br/>

            Company Name: <label>
        <input
                type="text" name="company_name"
                value="<c:out value="${company.company_name}" />"/>
        </label> <br/>

            Company Staff: <label>
        <input
                type="text" name="company_staff"
                value="<c:out value="${company.company_staff}" />"/>
        </label> <br/>

            Company Information: <label>
        <input
                type="text" name="company_information"
                value="<c:out value="${company.company_information}" />"/>
        </label> <br/>

            Company Website: <label>
        <input
                type="text" name="company_website"
                value="<c:out value="${company.company_website}" />"/>
        </label> <br/>

        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
