<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<style>
    body {
        background-color: #fbfbfb;
    }
    @media (min-width: 991.98px) {
        main {
            padding-left: 240px;
        }
    }

    /* Sidebar */
    .sidebar {
        position: fixed;
        top: 0;
        bottom: 0;
        left: 0;
        padding: 58px 0 0; /* Height of navbar */
        box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
        width: 240px;
        z-index: 600;
    }

    @media (max-width: 991.98px) {
        .sidebar {
            width: 100%;
        }
    }
    .sidebar .active {
        border-radius: 5px;
        box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
    }

    .sidebar-sticky {
        position: relative;
        top: 0;
        height: calc(100vh - 48px);
        padding-top: 0.5rem;
        overflow-x: hidden;
        overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
    }
</style>
<body>
<header>
    <jsp:include page="../header.jsp" />
    <jsp:include page="../sidebar.jsp" />
</header>

<main style="margin-top: 58px;">
    <div class="container pt-4 mt-5">
        <h1 class="text-success">Create Computer</h1>
        <form id="formSubmit" action="" method="post" class="mt-4">
            <input class="form-control" name="position" placeholder="Enter position">
            <input class="form-control mt-3" name="status" placeholder="Enter status">
            <input type="hidden" value="" id="id" name="id"/>
            <button id="btnAddOrUpdateComputer" class="btn btn-success mt-3" type="submit">Add computer</button>
        </form>
    </div>
</main>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
<script>
    $('#btnAddOrUpdateComputer').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if (id == "") {
            addNew(data);
        }

        function addNew(data) {
            $.ajax({
                url: '/computer',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    <%--window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";--%>
                    alert('Success')
                },
                error: function (error) {
                    <%--window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";--%>
                    alert("Failed")
                }
            });
        }
    });
</script>
</html>