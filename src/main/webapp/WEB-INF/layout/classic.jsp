<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <title><tiles:getAsString name="title"/></title>
</head>
<body>


<div class="container">
    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href='<spring:url value="/" />'>Twitt</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="test"><a href='<spring:url value="/" />'><span class="glyphicon glyphicon-home"></span>
                        Home</a></li>
                    <li class="test"><a href="<spring:url value="/users"/>"><span
                            class="glyphicon glyphicon-list"></span> Users</a></li>

                    <sec:authorize access="isAuthenticated()">
                        <li class="test"><a href="<spring:url value="/account"/>"><span
                                class="glyphicon glyphicon-info-sign"></span> Account</a></li>
                    </sec:authorize>
                    </ul>
                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="! isAuthenticated()">
                        <li class="test"><a href="<spring:url value="/registration"/>"><span
                                class="glyphicon glyphicon-user"></span> Register</a></li>
                    </sec:authorize>

                    <sec:authorize access="! isAuthenticated()">
                        <li class="test"><a href="<spring:url value="/login"/>"><span
                                class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="test"><a href="<spring:url value="/logout"/>"><span
                                class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    </sec:authorize>
                </ul>
                    <script type="text/javascript">
                        $(document).ready(function () {
                            $(".nav li").each(function () {
                                var href = $(this).find('a').attr('href');
                                if (href === window.location.pathname) {
                                    $(this).addClass('active');
                                }
                            });
                        });
                    </script>


            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>


    <tiles:insertAttribute name="body"/>
    <br>
    <br>

    <tiles:insertAttribute name="footer"/>


</div>
</body>
</html>
