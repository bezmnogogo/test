<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title: ${message}</title>
</head>
<body>
Test
<div>
    <form:form method="get" action="/test1">
    <table>
        <tr>
            <td><form:label path="message">Name</form:label></td>
            <td><form:input path="message" /></td>
        </tr>
    </table>
    </form:form>
</div>
</body>
</html>
