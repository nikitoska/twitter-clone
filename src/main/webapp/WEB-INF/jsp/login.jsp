
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/taglib.jsp" %>
<style>


    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }

    .form-signin-heading {
        margin-bottom: 10px;
    }

    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }

    .form-signin .form-control:focus {
        z-index: 2;
    }

    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>
<c:if test="${param.auth eq 'failure'}">
    <div class="alert alert-danger">
        Wrong username or password!
    </div>
</c:if>
<form class="form-signin" action='/login' method='POST'>
    <h2 class="form-signin-heading">Please sign in</h2>
    <label for="username" class="sr-only">Name</label>
    <input type="text" name='username' id="username" class="form-control" placeholder="Name" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>