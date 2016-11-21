
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/taglib.jsp" %>
<h1>Tweets list</h1>
<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th>Twit</th>
        <th>Date</th>
        <th>Username</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${twits}" var="twits">
    <tr>
        <td>${twits.description}</td>
        <td>${twits.date} </td>
        <td>${twits.user.name} </td>
    </tr>
    </tbody>
    </c:forEach>
</table>