<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
        <title><spring:message code="ViewRecipeTitle"/></title>
    </head>
    <body>
        <h1><spring:message code="ViewRecipeTitle"/></h1>
        <form id="j_idt13" name="j_idt13" method="post" enctype="application/x-www-form-urlencoded">
            <table>
                <tbody>
                    <tr>
                        <td><label for="id"><spring:message code="ViewRecipeLabel_id"/></label></td>
                        <td><c:out value="${recipe.id}"/></td>
                    </tr>
                    <tr>
                        <td><label for="cookBook"><spring:message code="ViewRecipeLabel_cookBook"/></label></td>
                        <td><c:out value="${recipe.cookBook.name}"/></td>
                    </tr>
                    <tr>
                        <td><label for="title"><spring:message code="ViewRecipeLabel_title"/></label></td>
                        <td><c:out value="${recipe.title}"/></td>
                    </tr>
                    <tr>
                        <td><label for="description"><spring:message code="ViewRecipeLabel_description"/></label></td>
                        <td><c:out value="${recipe.description}"/></td>
                    </tr>
                    <tr>
                        <td><label for="ingredients"><spring:message code="ViewRecipeLabel_ingredients"/></label></td>
                        <td><c:out value="${recipe.ingredients}"/></td>
                    </tr>
                    <tr>
                        <td><label for="instructions"><spring:message code="ViewRecipeLabel_instructions"/></label></td>
                        <td><c:out value="${recipe.instructions}"/></td>
                    </tr>
                </tbody>
            </table>

            <br />
            <br /><a href="Create.htm"><spring:message code="ViewRecipeCreateLink"/></a>
            <br /><a href="List.htm"><spring:message code="ViewRecipeShowAllLink"/></a>
            <br />
            <br /><a href="../index.htm"><spring:message code="ViewRecipeIndexLink"/></a>
        </form>
    </body>
</html>
