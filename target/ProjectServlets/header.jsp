<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header
    </title>
    <%-- Bootstrap --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>

    <%--    Awesome--%>
    <script src="https://kit.fontawesome.com/b0166f9752.js" crossorigin="anonymous"></script>
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"/>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                <li><a href="#" class="nav-link px-2 text-white">About</a></li>
            </ul>


            <div class="text-end">
                <%
                    Object firstName = session.getAttribute("firstName");
                    if (firstName != null) {
                        out.print("<a href=\"logout\">\n" +
                                "                    <button type=\"button\" class=\"btn btn-warning\">Logout</button>" +
                                "</a>");

                    } else {
                        out.print("<a href=\"login.jsp\">\n" +
                                "                    <button type=\"button\" class=\"btn btn-outline-light me-2\">Login</button></a>\n" +
                                "                <a href=\"registration.jsp\">\n" +
                                "                    <button type=\"button\" class=\"btn btn-warning\">Sign-up</button></a>");
                    }

                %>

            </div>
        </div>
    </div>
</header>

</body>
</html>
