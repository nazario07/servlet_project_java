<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Object firstName = session.getAttribute("firstName");%>
<html>
<head>
    <title>Header</title>
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
            <a href="index.jsp" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <img class="bi me-2" width="45" height="36" role="img" aria-label="Bootstrap" src="images/store.png">
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="index.jsp" class="nav-link px-2 text-white">Home</a></li>

                <%
                    Object role = session.getAttribute("role");
                    if (role != null) {
                        if (session.getAttribute("role").toString().equals("ADMIN")) {
                            out.print("<li><a href=\"createProduct.jsp\" class=\"nav-link px-2 text-white\">Create Product</a></li>");
                        }
                    }
                %>
                <li><a href="bucket.jsp" class="nav-link px-2 text-white">Bucket</a></li>
                <li><a href="cabinet.jsp" class="nav-link px-2 text-white">Cabinet</a></li>
            </ul>


            <div class="text-end">
                <span hidden id="login">
                    <a href="login.jsp">
                        <button type="button" class="btn btn-outline-light me-2">Login</button>
                    </a>

                    <a href="registration.jsp">
                        <button type="button" class="btn btn-warning">Sign-up</button>
                    </a>
                </span>

                <a href="logout" hidden id="logout">
                    <button type="button" onclick="localStorage.clear()" class="btn btn-warning">Logout</button>
                </a>

            </div>
        </div>
    </div>
</header>

<script>
    const isLogin = <%= firstName != null%>;
    const id = isLogin ? 'logout' : 'login'
    document.getElementById(id).removeAttribute('hidden');
</script>

</body>
</html>
