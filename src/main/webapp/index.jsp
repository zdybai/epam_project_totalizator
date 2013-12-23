<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Тотализатор</title>
  </head>
  <body><center>
      <form action="./login" method="GET">
          Логін:  <input type="text" name="login"/><br/>
          Пароль: <input type="password" name="password"/><br/>
          <input type="submit" value="Увійти">
      </form>
      <a href="./registerPage.jsp">Реєстрація</a>
  </center>
  </body>
</html>