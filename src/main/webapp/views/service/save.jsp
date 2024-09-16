<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 16/09/2024
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <jsp:include page="../header.jsp" />
    <jsp:include page="../sidebar.jsp" />
</header>

<main style="margin-top: 58px;">
    <div class="container pt-4 mt-5">
        <h1 class="text-success">Create Computer</h1>
        <form id="formSubmit" action="" method="post" class="mt-4">
            <input class="form-control" name="name" placeholder="Enter name">
            <input class="form-control mt-3" name="unit" placeholder="Enter unit">
            <input class="form-control mt-3" name="price" placeholder="Enter price">
            <input type="hidden" value="" id="id" name="id"/>
            <button id="btnAddOrUpdateComputer" class="btn btn-success mt-3" type="submit">Add computer</button>
        </form>
    </div>
</main>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
