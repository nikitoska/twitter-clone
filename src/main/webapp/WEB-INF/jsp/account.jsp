<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/taglib.jsp" %>


<form:form commandName="twit" cssClass="form-horizontal twitForm">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Add new twit
    </button>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Write twit</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">description:</label>
                        <div class="col-sm-10">
                            <form:input path="description" cssClass="form-control"/>
                            <form:errors path="description"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="publish"/>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form:form>
<div>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">My
            twits</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">My follower
            twits</a></li>

    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="home">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>Twit</th>
                    <th>Date</th>
                    <th>Operation</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user.twits}" var="twit">
                <tr>
                    <td>${twit.description}</td>
                    <td>${twit.date} </td>
                    <td><a href="<spring:url value="/twit/remove/${twit.id}"/>" class="btn btn-danger">Remove twit</a>
                    </td>


                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
        <div role="tabpanel" class="tab-pane" id="profile">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>Twit</th>
                    <th>Date</th>
                    <th>Username</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user.followers}" var="followers">
                <c:forEach items="${followers.twits}" var="twits">
                    <tr>
                        <td>${twits.description}</td>
                        <td>${twits.date} </td>
                        <td>${twits.user.name} </td>
                    </tr>
                </c:forEach>

                </tbody>
                </c:forEach>
            </table>
        </div>

    </div>

</div>


<script type="text/javascript">
    $(document).ready(function () {
        $(".twitForm").validate(
                {
                    rules: {
                        description: {
                            required: true,
                            minlength: 1
                        }
                    },
                    highlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    }
                }
        );
    })

</script>

