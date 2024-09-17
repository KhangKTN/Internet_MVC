<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<head>
    <title>Internet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="../paging/jquery.twbsPagination.js"></script>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<header>
    <jsp:include page="../views/header.jsp" />
    <jsp:include page="../views/sidebar.jsp" />
</header>

<main style="margin-top: 58px;">
    <div class="container pt-4 mb-5">
        <dec:body/>
    </div>
</main>
<script>
   $(document).ready(function () {
       $('a.list-group-item').each(function () {
           let href = window.location.href
           if($(this).prop("href") === href) $(this).addClass('active')
       })
   })
</script>
</body>
</html>