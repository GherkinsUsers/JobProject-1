<%--
  Created by IntelliJ IDEA.
  User: AR
  Date: 20.03.2017
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All Companies</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Company ID</th>
        <th>Company ID Country</th>
        <th>Company Name</th>
        <th>Company Staff</th>
        <th>Company Information</th>
        <th>Company Website</th>
    </tr>
    </thead>
    <tbody>

    <%--@elvariable id="companies" type="java.util.List"--%>
    <c:forEach items="${companies}" var="company">
        <tr>
            <td><c:out value="${company.id_company}" /></td>
            <td><c:out value="${company.id_country}" /></td>
            <td><c:out value="${company.company_name}" /></td>
            <td><c:out value="${company.company_staff}" /></td>
            <td><c:out value="${company.company_information}" /></td>
            <td><c:out value="${company.company_website}" /></td>
            <td><a href="CompanyController?action=edit&id_company=<c:out value="${company.id_company}"/>">Update</a></td>
            <td><a href="CompanyController?action=delete&id_company=<c:out value="${company.id_company}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="CompanyController?action=insert">Add Company</a></p>
</body>
</html>
