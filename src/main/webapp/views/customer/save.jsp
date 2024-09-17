<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1 class="text-primary">Create Customer</h1>
<form id="formSubmit" method="post" class="mt-5">
    <input class="form-control" name="name" value="${model.name}" placeholder="Enter Name">
    <input class="form-control mt-3" name="address" value="${model.address}" placeholder="Enter Address">
    <input class="form-control mt-3" name="phone" value="${model.phone}" placeholder="Enter phone">
    <input class="form-control mt-3" type="email" value="${model.email}" ${model.id == null ? "" : "disabled"} name="email" placeholder="Enter email">
    <input type="hidden" value="${model.id}" id="id" name="id"/>
    <button id="btnAddOrUpdateCustomer" class="btn btn-primary mt-3" type="submit">${model.id == null ? "Add" : "Update"} computer</button>
</form>
<script>
    $('#btnAddOrUpdateCustomer').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if (id == "") {
            add(data);
        }
        else update(data)

        function add(data) {
            $.ajax({
                url: '/customer',
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

        function update(data) {
            $.ajax({
                url: '/customer',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    <%--window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=update_success";--%>
                    alert("Successfully!")
                },
                error: function (error) {
                    <%--window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";--%>
                    alert("Failed!")
                }
            });
        }
    });
</script>
</body>
</html>