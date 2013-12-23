<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>BookStore</title>
    <link rel="stylesheet" type="text/css" href="resources/styles.css"/>
</head>
<body>
        <p align=right>User:"${currentUser.login}"   Cash = "${currentUser.cash}"
        <a href="./logout" align=right>Log out</a>
<table align=center>
    <caption>Bets</caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Owner Id</th>
        <th>Event Id</th>
        <th>Amount</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bets}" var="bet">
        <tr>
            <td>${bet.betId}</td>
            <td>${bet.ownerId}</td>
            <td>${bet.eventId}</td>
            <td>${bet.amount}</td>
            <td>${bet.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>