<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>CTF Hacking the command</title>
</head>
<body>
<h1>All you need is command</h1>
<br/>
<!-- Create a form that submits a command to the server -->
<form action="hello-servlet" method="post">
    <input type="text" name="command" placeholder="Enter command here">
    <input type="submit" value="Submit">
</form>
<br/>
<!-- Show the output of the command -->
<% if (request.getAttribute("output") != null) { %>
    <pre><%= request.getAttribute("output") %></pre>
<% } %>
<br/>
</body>
</html>