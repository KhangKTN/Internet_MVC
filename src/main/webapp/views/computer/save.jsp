<html>
<head>
    <title>Create Computer</title>
</head>
<body>
<div>
    <h1 class="text-primary">Create Computer</h1>
    <form id="formSubmit" method="post" class="mt-4">
        <input class="form-control" name="position" placeholder="Enter position"/>
        <input class="form-control mt-3" name="status" placeholder="Enter status"/>
        <input type="hidden" value="" id="id" name="id"/>
        <button id="btnAddOrUpdateComputer" class="btn btn-primary mt-3" type="submit">Add computer</button>
    </form>
</div>
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