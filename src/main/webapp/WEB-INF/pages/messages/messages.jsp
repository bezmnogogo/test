<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <input type="text" id="messageText" />
        <input type="button" id="addMessage" value="addMessage">
    </div>
    <div class="row">
        <table id="messageTable" class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Text</th>
                <th>Del</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="message" items="${messagesList}">
                <tr id="row_${message.id}">
                    <th scope="row">${message.id}</th>
                    <td>${message.text}</td>
                    <td><input type='button' class='delete-message' value='delete' data-messageid='${message.id}'/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    jQuery(document).ready(function ($) {

        var baseDeleteUrl = "<c:url value="/messages/delete"/>";

        $('#addMessage').click(function() {
            var text = $('#messageText').val();

            var qData = {
                text: text
            };

            $.ajax({
                type: 'POST',
                url: '<c:url value="/messages/add" />',
                contentType: 'application/json',
                data: JSON.stringify(qData),
                success: function(serverResult) {
                    var cell1 = "<th scope='row'>"+ serverResult.id +"</th>";
                    var cell2 = "<td>"+ serverResult.text +"</td>";

                    var cell3 = "<td><input type='button' class='delete-message' value='delete' data-messageid="+serverResult.id+"/></td>";
                    $('#messageTable tr:last').after("<tr id='" + serverResult.id + "'>" + cell1 + cell2 + cell3 + '</tr>');

                },
                error: function() {
                    alert('error');
                }
            });
        });

        $('.delete-message').click(function() {

            var messageId = $(this).data('messageid')

            var qData = {
                id: messageId
            };

            $.ajax({
                type: 'POST',
                url: '<c:url value="/messages/delete" />',
                contentType: 'application/json',
                data: JSON.stringify(qData),
                success: function(serverResult) {

                    if (serverResult === true) {
                        var selector = 'row_' + messageId;
                        $('#' + selector).remove();
                    } else {
                        alert('delete error');
                    }

                },
                error: function() {
                    alert('error');
                }
            });
        });
    });
</script>
</body>
</html>
