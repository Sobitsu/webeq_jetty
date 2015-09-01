<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Пользователи</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>Список пользователей</h2>  
    <table>
        <tr>
            <td>User</td><td>Пароль</td><td>ФИО</td><td>Роль</td><td></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${users.user}</td>
            <td>${users.password}</td>
            <td>${users.fio}</td>
            <td>${users.role}</td>
            <td>delete</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Добавить</a>
</body>
</html>