<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
        <title><spring:message code="ListCookBookTitle"/></title>
    </head>
    <body>
        <h1><spring:message code="ListCookBookTitle"/></h1>
        <form id="j_idt12" name="j_idt12" method="post" class="crud_list_form" enctype="application/x-www-form-urlencoded">
           <input type="hidden" name="j_idt12" value="j_idt12" />
            <div id="j_idt12:messagePanel"></div>

            <table border="0" cellpadding="2" cellspacing="0" rules="all" style="border:solid 1px">
                <thead>
                    <tr>
                        <th scope="col"><spring:message code="ListCookBookTitle_id"/></th>
                        <th scope="col"><spring:message code="ListCookBookTitle_name"/></th>
                        <th scope="col"><spring:message code="ListCookBookTitle_owner"/></th>
                        <th scope="col"><spring:message code="ListCookBookTitle_actions"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cookBooks}" var="cookBook">
                    <form id="j_idt12:<c:out value='${cookBook.id}'/>" name="j_idt12:<c:out value='${cookBook.id}'/>" method="post" enctype="application/x-www-form-urlencoded">
                        <tr class="crud_odd_row">
                            <td><c:out value="${cookBook.id}"/><input type="hidden" id="id" name="id" value="<c:out value='${cookBook.id}'/>"/></td>
                            <td><c:out value="${cookBook.name}"/><input type="hidden" id="name" name="name" value="<c:out value='${cookBook.name}'/>"/></td>
                            <td><c:out value="${cookBook.owner}"/><input type="hidden" id="ownerId" name="ownerId" value="<c:out value='${cookBook.ownerId}'/>"/></td>
                            <td>
                                <a href="View.htm?id=<c:out value="${cookBook.id}"/>"><spring:message code="ListCookBookViewLink"/></a> <a href="Edit.htm?id=<c:out value="${cookBook.id}"/>"><spring:message code="ListCookBookEditLink"/></a> <a href="#" onClick="document.getElementById('j_idt12:<c:out value='${cookBook.id}'/>').submit();"/><spring:message code="ListCookBookDestroyLink"/></a></td>
                        </tr>
                    </form>
                    </c:forEach>
                </tbody>
            </table>

            <br /><a href="Create.htm"><spring:message code="ListCookBookCreateLink"/></a>
            <br />
            <br /><a href="../index.htm"><spring:message code="ListCookBookIndexLink"/></a>
        </form>
    </body>
</html>
