<%-- 
    Document   : step1
    Created on : 04.06.2015, 14:45:26
    Author     : andre
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! step2</h1>
        <strong>
            Arriving: ${sessionScope.attrFromFlight.id} + ${sessionScope.attrFromFlight.departure}
        </strong>
        <form method="post">
            <table>            
    <c:forEach var="flight" items="${requestComebackFlights}" >
        <tr>
            <td>
                <input type="radio" name="paramComebackFlight" value="${flight.id}"/>
            </td>
            <td>
                ${flight.company}
            </td>
            <td>
                ${flight.arrival}
            </td>
            
            <td>
                ${flight.from}
            </td>
            
            <td>
                ${flight.destination}
            </td>
        </tr>
    </c:forEach>
</table>
            <input type="submit" value="do submit">
        </form>
    </body>
</html>
