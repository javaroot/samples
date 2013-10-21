<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
      <title><spring:message code="EditRecipeTitle"/></title>
   </head>
   <body>
      <h1><spring:message code="EditRecipeTitle"/></h1>
      <form id="j_idt13" name="j_idt13" method="post" enctype="application/x-www-form-urlencoded">
         <table>
            <tbody>
               <tr>
                  <td><label for="id"><spring:message code="EditRecipeLabel_id"/></label></td>
                  <td><c:out value="${recipe.id}"/></td>
               </tr>
               <tr>
                  <td><label for="cookBookId"><spring:message code="EditRecipeLabel_cookBook"/></label></td>
                  <td>
                     <select id="cookBookId" name="cookBookId" title="<spring:message code="EditRecipeTitle_cookBook"/>">
                        <c:forEach items="${cookBooks}" var="cookBook">
                           <option value="<c:out value='${cookBook.id}'/>" ${cookBook.id == recipe.cookBookId ? 'selected="selected"' : ''} ><c:out value="${cookBook.name}"/></option>
                        </c:forEach>
                     </select>
                  </td>
               </tr>
               <tr>
                  <td><label for="title"><spring:message code="EditRecipeLabel_title"/></label></td>
                  <td><input id="title" type="text" name="title" title="<spring:message code="EditRecipeTitle_title"/>" value="<c:out value="${recipe.title}"/>"/></td>
               </tr>
               <tr>
                  <td><label for="description"><spring:message code="EditRecipeLabel_description"/></label></td>
                  <td><input id="description" type="text" name="description" title="<spring:message code="EditRecipeTitle_description"/>" value="<c:out value="${recipe.description}"/>"/></td>
               </tr>
               <tr>
                  <td><label for="ingredients"><spring:message code="EditRecipeLabel_ingredients"/></label></td>
                  <td><input id="ingredients" type="text" name="ingredients" title="<spring:message code="EditRecipeTitle_ingredients"/>" value="<c:out value="${recipe.ingredients}"/>"/></td>
               </tr>
               <tr>
                  <td><label for="instrucions"><spring:message code="EditRecipeLabel_instructions"/></label></td>
                  <td><input id="instructions" type="text" name="instructions" title="<spring:message code="EditRecipeTitle_instructions"/>" value="<c:out value="${recipe.instructions}"/>"/></td>
               </tr>
            </tbody>
         </table>

         <br />
         <a href="#" onClick="document.getElementById('j_idt13').submit();"><spring:message code="EditRecipeSaveLink"/></a>
         <br />
         <br /><a href="List.htm"><spring:message code="EditRecipeShowAllLink"/></a>
         <br />
         <br /><a href="../index.htm"><spring:message code="EditRecipeIndexLink"/></a>
      </form>
   </body>
</html>
