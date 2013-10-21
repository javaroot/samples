<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
        <title><spring:message code="CreateCookBookUserTitle"/></title>
    </head>
    <body>
        <h1><spring:message code="CreateCookBookUserTitle"/></h1>
        <form id="j_idt13" name="j_idt13" method="post" enctype="application/x-www-form-urlencoded">
            <table>
                <tbody>
                    <tr>
                        <td><label for="firstName"><spring:message code="CreateCookBookUserLabel_firstName"/></label></td>
                        <td><input id="firstName" type="text" name="firstName" title="<spring:message code="CreateCookBookUserTitle_firstName"/>" /></td>
                    </tr>
                    <tr>
                        <td><label for="lastName"><spring:message code="CreateCookBookUserLabel_lastName"/></label></td>
                        <td><input id="lastName" type="text" name="lastName" title="<spring:message code="CreateCookBookUserTitle_lastName"/>" /></td>
                    </tr>
                    <tr>
                        <td><label for="email"><spring:message code="CreateCookBookUserLabel_email"/></label></td>
                        <td><input id="email" type="text" name="email" title="<spring:message code="CreateCookBookUserTitle_email"/>" /></td>
                    </tr>
                    <tr>
                        <td><label for="password"><spring:message code="CreateCookBookUserLabel_password"/></label></td>
                        <td><input id="password" type="password" name="password" value="" title="<spring:message code="CreateCookBookUserTitle_password"/>" /></td>
                    </tr>
                </tbody>
            </table>

            <br />
            <a href="#" onClick="document.getElementById('j_idt13').submit();"><spring:message code="CreateCookBookUserSaveLink"/></a>
            <br />
            <br /><a href="List.htm"><spring:message code="CreateCookBookUserShowAllLink"/></a>
            <br />
            <br /><a href="../index.htm"><spring:message code="CreateCookBookUserIndexLink"/></a>
        </form>
    </body>
</html>
