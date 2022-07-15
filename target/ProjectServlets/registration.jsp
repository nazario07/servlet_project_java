<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="./css/registration.css">
</head>
<body>

<div id="registration-form">
    <div class='fieldset'>
        <legend>Registration</legend>
        <form onsubmit="handleRegistration(event)" data-validate="parsley">
            <div class='row'>
                <label for='firstname'>First Name</label>
                <input type="text" placeholder="First Name" name='firstName' id='firstname' data-required="true"
                       data-error-message="Your First Name is required">
            </div>
            <div class='row'>
                <label for='lastname'>First Name</label>
                <input type="text" placeholder="Last Name" name='lastName' id='lastname' data-required="true"
                       data-error-message="Your Last Name is required">
            </div>
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
            <div class="errorMessage" id="errorMessage">
            </div>
            <input type="submit" value="Register">

        </form>
    </div>
</div>

<script src="js/form-handler.js"></script>
</body>
</html>
