<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" media="screen" href="css/styles.css">

    <script src="js/jquery-2.2.3.js"></script>
    <script src="js/validateLogin.js"></script>

</head>


<body>

<form action="/Login" id="Main page" class="common_form" method="post">
    <ul>
        <li>
            <h2>Fortune cookies login page (login or register)</h2>

        </li>
        <li>
            <label for="username">UserName:</label>
            <input id="username" type="text" name="name" placeholder="Enter registered username"/>
        </li>
        <li>
            <label for="password">Password:</label>
            <input id="password" type="password" name="password" placeholder="Enter the password" pattern=".{2,}"/>
        </li>
        <li>

            <button id="login-button" class="submit" type="submit">Login</button>
            <a href="registerForm.html">
                <button class="submit" type="button">Register</button>
            </a>
        </li>
        <li>
            <a href="cookieMessage.html">
                <button class="submit" type="button">Get cookie</button>
            </a>

        </li>
        <li id="errors">


        </li>

    </ul>

</form>

</body>
</html>
