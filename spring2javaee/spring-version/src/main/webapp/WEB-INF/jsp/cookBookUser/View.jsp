<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
        <title><spring:message code="ViewCookBookUserTitle"/></title>
    </head>
    <body>
        <h1><spring:message code="ViewCookBookUserTitle"/></h1>
        <form id="j_idt13" name="j_idt13" method="post" enctype="application/x-www-form-urlencoded">
            <table>
                <tbody>
                    <tr>
                        <td><label for="id"><spring:message code="ViewCookBookUserLabel_id"/></label></td>
                        <td><c:out value="${user.id}"/></td>
                    </tr>
                    <tr>
                        <td><label for="firstName"><spring:message code="ViewCookBookUserLabel_firstName"/></label></td>
                        <td><c:out value="${user.firstName}"/></td>
                    </tr>
                    <tr>
                        <td><label for="lastName"><spring:message code="ViewCookBookUserLabel_lastName"/></label></td>
                        <td><c:out value="${user.lastName}"/></td>
                    </tr>
                    <tr>
                        <td><label for="email"><spring:message code="ViewCookBookUserLabel_email"/></label></td>
                        <td><c:out value="${user.email}"/></td>
                    </tr>
                </tbody>
            </table>

            <br />
            <br /><a href="Create.htm"><spring:message code="ViewCookBookUserCreateLink"/></a>
            <br /><a href="List.htm"><spring:message code="ViewCookBookUserShowAllLink"/></a>
            <br />
            <br /><a href="../index.htm"><spring:message code="ViewCookBookUserIndexLink"/></a>
        </form>
    </body>
</html>
