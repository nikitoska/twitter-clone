<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/taglib.jsp" %>

<div class="row">
    <div class="col-md-2"><h2>${user.name}</h2></div>
</div>
<div class="row">
    <div class="col-md-1">
        <a href="<spring:url value="/users/${user.id}/follow"/>" class="btn btn-primary">follow</a></div>
    <div class="col-md-1 ">
        <a href="<spring:url value="/users/${user.id}/unfollow"/>" class="btn btn-primary">unfollow</a></div>
</div>
<br>

<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th>Twit</th>
        <th>Date</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${user.twits}" var="twit">
    <tr>
        <td>${twit.description}</td>
        <td>${twit.date}
        </td>

    </tr>
    </tbody>
    </c:forEach>
</table>


