<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link type="text/css" rel="stylesheet" href="../resources/css/crud.css" />
      <title><spring:message code="ViewCookBookTitle"/></title>
   </head>
   <body>
      <h1><spring:message code="ViewCookBookTitle"/></h1>
      <form id="j_idt13" name="j_idt13" method="post" enctype="application/x-www-form-urlencoded">
         <table>
            <tbody>
               <tr>
                  <td><label for="id"><spring:message code="ViewCookBookLabel_id"/></label></td>
                  <td><c:out value="${cookBook.id}"/></td>
               </tr>
               <tr>
                  <td><label for="Name"><spring:message code="ViewCookBookLabel_name"/></label></td>
                  <td><c:out value="${cookBook.name}"/></td>
               </tr>
               <tr>
                  <td><label for="owner"><spring:message code="ViewCookBookLabel_owner"/></label></td>
                  <td><c:out value="${cookBook.owner.firstName}"/> <c:out value="${cookBook.owner.lastName}"/></td>
               </tr>
            </tbody>
         </table>

         <br />
         <br /><a href="Create.htm"><spring:message code="ViewCookBookCreateLink"/></a>
         <br /><a href="List.htm"><spring:message code="ViewCookBookShowAllLink"/></a>
         <br />
         <br /><a href="../index.htm"><spring:message code="ViewCookBookIndexLink"/></a>
      </form>
   </body>
</html>
