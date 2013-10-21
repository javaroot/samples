<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
        <title><spring:message code="EditCookBookUserTitle"/></title>
    </head>
    <body>
        <h1><spring:message code="EditCookBookUserTitle"/></h1>
        <form id="j_idt13" name="j_idt13" method="post" enctype="application/x-www-form-urlencoded">
            <table>
                <tbody>
                    <tr>
                        <td><label for="firstName"><spring:message code="EditCookBookUserLabel_firstName"/></label></td>
                        <td><input id="firstName" type="text" name="firstName" title="<spring:message code="EditCookBookUserTitle_firstName"/>" value="<c:out value="${user.firstName}"/>" /></td>
                    </tr>
                    <tr>
                        <td><label for="lastName"><spring:message code="EditCookBookUserLabel_lastName"/></label></td>
                        <td><input id="lastName" type="text" name="lastName" title="<spring:message code="EditCookBookUserTitle_lastName"/>" value="<c:out value="${user.lastName}"/>"/></td>
                    </tr>
                    <tr>
                        <td><label for="email"><spring:message code="EditCookBookUserLabel_email"/></label></td>
                        <td><input id="email" type="text" name="email" title="<spring:message code="EditCookBookUserTitle_email"/>" value="<c:out value="${user.email}"/>"/></td>
                    </tr>
                    <tr>
                        <td><label for="password"><spring:message code="EditCookBookUserLabel_password"/></label></td>
                        <td><input id="password" type="password" name="password" title="<spring:message code="EditCookBookUserTitle_password"/>" value="<c:out value="${user.password}"/>"/></td>
                    </tr>
                </tbody>
            </table>

            <br />
            <a href="#" onClick="document.getElementById('j_idt13').submit();"><spring:message code="EditCookBookUserSaveLink"/></a>
            <br />
            <br /><a href="List.htm"><spring:message code="EditCookBookUserShowAllLink"/></a>
            <br />
            <br /><a href="../index.htm"><spring:message code="EditCookBookUserIndexLink"/></a>
        </form>
    </body>
</html>
