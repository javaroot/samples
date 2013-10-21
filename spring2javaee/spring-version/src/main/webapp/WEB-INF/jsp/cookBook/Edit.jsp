<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
      <title><spring:message code="EditCookBookTitle"/></title>
   </head>
   <body>
      <h1><spring:message code="EditCookBookTitle"/></h1>
      <form id="j_idt13" name="j_idt13" method="post" enctype="application/x-www-form-urlencoded">
         <table>
            <tbody>
               <tr>
                  <td><label for="id"><spring:message code="EditCookBookLabel_id"/></label></td>
                  <td><c:out value="${cookBook.id}"/></td>
               </tr>
               <tr>
                  <td><label for="name"><spring:message code="EditCookBookLabel_name"/></label></td>
                  <td><input id="name" type="text" name="name" title="<spring:message code="EditCookBookTitle_name"/>" value="<c:out value="${cookBook.name}"/>"/></td>
               </tr>
               <tr>
                  <td><label for="ownerId"><spring:message code="EditCookBookLabel_owner"/></label></td>
                  <td>
                     <select id="ownerId" name="ownerId" title="<spring:message code="EditCookBookTitle_owner"/>">
                        <c:forEach items="${users}" var="owner">
                           <option value="<c:out value='${owner.id}'/>" ${owner.id == cookBook.ownerId ? 'selected="selected"' : ''}><c:out value="${owner.firstName}"/> <c:out value="${owner.lastName}"/></option>
                        </c:forEach>
                     </select>
                  </td>
               </tr>
            </tbody>
         </table>

         <br />
         <a href="#" onClick="document.getElementById('j_idt13').submit();"><spring:message code="EditCookBookSaveLink"/></a>
         <br />
         <br /><a href="List.htm"><spring:message code="EditCookBookShowAllLink"/></a>
         <br />
         <br /><a href="../index.htm"><spring:message code="EditCookBookIndexLink"/></a>
      </form>
   </body>
</html>
