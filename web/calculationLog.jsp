<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
<head>
    <title>Поиследние 10 операций</title>
</head>
<body>
<h1>Последние 10 операций</h1>>
<form action="/WebCalcApp/CalculationLog" method="post">
    <table class="tdata">
        <tr>
            <th>Номер операции</th>
            <th>Первый параметр</th>
            <th>Второй параметр</th>
            <th>Результат</th>
            <th>Операция</th>
            <th>Дата</th>
        </tr>
        <c:forEach var="log" items="${logs}">
            <tr>
                <td><c:out value="${log.id}"/></td>
                <td><c:out value="${log.param1}"/></td>
                <td><c:out value="${log.param2}"/></td>
                <td><c:out value="${log.result}"/></td>
                <td><c:out value="${log.operation}"/></td>
                <td><c:out value="${log.creationDateAsString}"/></td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit">Показать</button>
</form>
<form>
    <a href="/WebCalcApp/index.jsp">Вернуться к расчетам</a>
</form>>
</body>
</html>
