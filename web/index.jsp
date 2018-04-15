<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String res = (String)request.getAttribute("result");
    if(res == null) res ="";
    String a = request.getParameter("a") != null ?  request.getParameter("a") :"";
    String b = request.getParameter("b") != null ?  request.getParameter("b") :"";
    String op = request.getParameter("op") != null ?  request.getParameter("op") :"";%>
<html>
  <head>
    <title>WebCalculator</title>
  </head>
  <body>
    <h1> Web Calculator </h1>
    <form action="/WebCalcApp/CalcServlet" method="post">
        <table>
          <tr>
            <td>Число1</td>
            <td><input type="text" name="a" value="<%=a%>"></td>
          </tr>
          <tr>
            <td>Операция</td>
            <td><input type="text" name="op" value="<%=op%>"></td>
          </tr>
          <tr>
            <td>Число2</td>
            <td><input type="text" name="b" value="<%=b%>"></td>
          </tr>
        </table>
      <button type="submit">Вычеслить</button>
    </form>
    <h3> Result: <%=res%></h3>
  <form>
      <a href="/WebCalcApp/calculationLog.jsp">Показать 10 последних операций</a>
  </form>>
  </body>
</html>
