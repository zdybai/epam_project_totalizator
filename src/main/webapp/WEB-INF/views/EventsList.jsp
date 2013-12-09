<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>BookStore</title>
    <link rel="stylesheet" type="text/css" href="resources/styles.css"/>
</head>
<body>
<table>
    <caption>Events</caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Start Bet Time</th>
        <th>End Bet Time</th>
        <th>Event Time</th>
        <th>Result</th>
        <th>Is Active</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${events}" var="event">
        <tr>
            <td>${event.id}</td>
            <td>${event.name}</td>
            <td>${event.startBetTime}</td>
            <td>${event.endBetTime}</td>
            <td>${event.eventTime}</td>
            <td>${event.result}</td>
            <td>${event.active}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>