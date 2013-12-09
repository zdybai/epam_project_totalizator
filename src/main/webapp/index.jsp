<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%
       String site = new String("./events");
       response.setStatus(response.SC_MOVED_TEMPORARILY);
       response.setHeader("Location", site);
    %>
</body>
</html>