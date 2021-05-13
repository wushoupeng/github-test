<%--
  Created by IntelliJ IDEA.
  User: 武守朋
  Date: 2021/5/7
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <form:form modelAttribute="user" action="login" method="post">
        <p>
            <div><form:errors path="email" cssClass="redColor"></form:errors> </div>
            用户邮箱:<form:input path="email"/>
        </p>
        <p>
        <div><form:errors path="password" cssClass="redColor"></form:errors> </div>
            密码:<form:input path="password"/>
        </p>
        <p>
            <input type="reset" value="重置">
            <input type="submit" value="提交">
        </p>
    </form:form>
</body>
</html>
