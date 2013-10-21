<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
        <title><spring:message code="ListCookBookUserTitle"/></title>
    </head>
    <body>
        <h1><spring:message code="ListCookBookUserTitle"/></h1>
        <form id="j_idt12" name="j_idt12" method="post" class="crud_list_form" enctype="application/x-www-form-urlencoded">
           <input type="hidden" name="j_idt12" value="j_idt12" />
            <div id="j_idt12:messagePanel"></div>

            <table border="0" cellpadding="2" cellspacing="0" rules="all" style="border:solid 1px">
                <thead>
                    <tr>
                        <th scope="col"><spring:message code="ListCookBookUserTitle_id"/></th>
                        <th scope="col"><spring:message code="ListCookBookUserTitle_firstName"/></th>
                        <th scope="col"><spring:message code="ListCookBookUserTitle_lastName"/></th>
                        <th scope="col"><spring:message code="ListCookBookUserTitle_email"/></th>
                        <th scope="col"><spring:message code="ListCookBookUserTitle_actions"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cookBookUsers}" var="user">
                    <form id="j_idt12:<c:out value='${user.id}'/>" name="j_idt12:<c:out value='${user.id}'/>" method="post" enctype="application/x-www-form-urlencoded">
                        <tr class="crud_odd_row">
                            <td><c:out value="${user.id}"/><input type="hidden" id="id" name="id" value="<c:out value='${user.id}'/>"/></td>
                            <td><c:out value="${user.firstName}"/><input type="hidden" id="name" name="firstName" value="<c:out value='${user.firstName}'/>"/></td>
                            <td><c:out value="${user.lastName}"/><input type="hidden" id="lastName" name="lastName" value="<c:out value='${user.lastName}'/>"/></td>
                            <td><c:out value="${user.email}"/><input type="hidden" id="email" name="email" value="<c:out value='${user.email}'/>"/></td>
                            <td>
                                <a href="View.htm?id=<c:out value="${user.id}"/>"><spring:message code="ListCookBookUserViewLink"/></a> <a href="Edit.htm?id=<c:out value="${user.id}"/>"><spring:message code="ListCookBookUserEditLink"/></a> <a href="#" onClick="document.getElementById('j_idt12:<c:out value='${user.id}'/>').submit();"/><spring:message code="ListCookBookUserDestroyLink"/></a></td>
                        </tr>
                    </form>
                    </c:forEach>
                </tbody>
            </table>

            <br /><a href="Create.htm"><spring:message code="ListCookBookUserCreateLink"/></a>
            <br />
            <br /><a href="../index.htm"><spring:message code="ListCookBookUserIndexLink"/></a>
        </form>
    </body>
</html>
