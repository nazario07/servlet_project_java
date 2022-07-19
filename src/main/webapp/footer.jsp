<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 18.07.2022
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Footer</title>
  <%-- Bootstrap --%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
          crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
  <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <div class="col-md-4 d-flex align-items-center">
      <a href="index.jsp" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
        <img class="bi" width="45" height="36" src="images/store.png" alt="emblem">
      </a>
      <span class="mb-3 mb-md-0 text-muted">&copy; 2022 Online Store </span>
    </div>

    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
      <li class="ms-3"><a class="text-muted" href="https://www.instagram.com/"><img class="bi" width="36" height="32" src="images/insta.png" alt="instagram"></a></li>
      <li class="ms-3"><a class="text-muted" href="https://uk-ua.facebook.com/"><img class="bi" width="36" height="32" src="images/fb.png" alt="facebook"></a></li>
      <li class="ms-3"><a class="text-muted" href="https://twitter.com/"><img class="bi" width="36" height="32" src="images/twitter.png" alt="twitter"></a></li>
    </ul>
  </footer>
</div>
</body>
</html>
