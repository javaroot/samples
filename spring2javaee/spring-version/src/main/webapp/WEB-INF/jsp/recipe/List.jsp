<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
        <title><spring:message code="ListRecipeTitle"/></title>
    </head>
    <body>
        <h1><spring:message code="ListRecipeTitle"/></h1>
        <form id="j_idt12" name="j_idt12" method="post" class="crud_list_form" enctype="application/x-www-form-urlencoded">
           <input type="hidden" name="j_idt12" value="j_idt12" />
            <div id="j_idt12:messagePanel"></div>

            <table border="0" cellpadding="2" cellspacing="0" rules="all" style="border:solid 1px">
                <thead>
                    <tr>
                        <th scope="col"><spring:message code="ListRecipeTitle_id"/></th>
                        <th scope="col"><spring:message code="ListRecipeTitle_cookBook"/></th>
                        <th scope="col"><spring:message code="ListRecipeTitle_title"/></th>
                        <th scope="col"><spring:message code="ListRecipeTitle_description"/></th>
                        <th scope="col"><spring:message code="ListRecipeTitle_ingredients"/></th>
                        <th scope="col"><spring:message code="ListRecipeTitle_instructions"/></th>
                        <th scope="col"><spring:message code="ListRecipeTitle_actions"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${recipes}" var="recipe">
                    <form id="j_idt12:<c:out value='${recipe.id}'/>" name="j_idt12:<c:out value='${recipe.id}'/>" method="post" enctype="application/x-www-form-urlencoded">
                        <tr class="crud_odd_row">
                            <td><c:out value="${recipe.id}"/><input type="hidden" id="id" name="id" value="<c:out value='${recipe.id}'/>"/></td>
                            <td><c:out value="${recipe.cookBook}"/><input type="hidden" id="cookBookId" name="cookBookId" value="<c:out value='${recipe.cookBookId}'/>"/></td>
                            <td><c:out value="${recipe.title}"/><input type="hidden" id="title" name="title" value="<c:out value='${recipe.title}'/>"/></td>
                            <td><c:out value="${recipe.description}"/><input type="hidden" id="description" name="description" value="<c:out value='${recipe.description}'/>"/></td>
                            <td><c:out value="${recipe.ingredients}"/><input type="hidden" id="ingredients" name="ingredients" value="<c:out value='${recipe.ingredients}'/>"/></td>
                            <td><c:out value="${recipe.instructions}"/><input type="hidden" id="instructions" name="instructions" value="<c:out value='${recipe.instructions}'/>"/></td>
                            <td>
                                <a href="View.htm?id=<c:out value="${recipe.id}"/>"><spring:message code="ListRecipeViewLink"/></a> <a href="Edit.htm?id=<c:out value="${recipe.id}"/>"><spring:message code="ListRecipeEditLink"/></a> <a href="#" onClick="document.getElementById('j_idt12:<c:out value='${recipe.id}'/>').submit();"/><spring:message code="ListRecipeDestroyLink"/></a></td>
                        </tr>
                    </form>
                    </c:forEach>
                </tbody>
            </table>

            <br /><a href="Create.htm"><spring:message code="ListRecipeCreateLink"/></a>
            <br />
            <br /><a href="../index.htm"><spring:message code="ListRecipeIndexLink"/></a>
        </form>
    </body>
</html>
