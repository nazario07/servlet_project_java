<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="./css/registration.css">
</head>
<body>
<div id="registration-form">
    <div class='fieldset'>
        <legend>Sign In</legend>
        <form action="login" method="post" data-validate="parsley">
            <div class='row'>
                <label for="email">E-mail</label>
                <input type="text" id="email" placeholder="E-mail" name='email' data-required="true" data-type="email"
                       data-error-message="Your E-mail is required">
            </div>
            <div class='row'>
                <label for="password">Confirm your E-mail</label>
                <input type="password" id="password" placeholder="Confirm your E-mail" name='password'
                       data-required="true" data-error-message="Your E-mail must correspond">
            </div>
            <input type="submit" value="Sign In">
        </form>
    </div>
</div>
</body>
</html>
