<h1 class="text-primary">Create Service</h1>
<form id="formSubmit" action="" method="post" class="mt-4 w-75">
    <label class="form-label">Service name:</label>
    <input class="form-control" value="${model.name}" name="name" placeholder="Enter service name">
    <label class="mt-3 form-label">Unit:</label>
    <input class="form-control" value="${model.unit}" name="unit" placeholder="Enter unit">
    <label class="mt-3 form-label">Price:</label>
    <input class="form-control" value="${model.price}" type="number" name="price" placeholder="Enter price">
    <input type="hidden" value="${model.id}" id="id" name="id"/>
    <button id="btnAddOrUpdateService" class="btn btn-primary mt-3" type="submit">${model.id == null ? "Add" : "Update"} service</button>
</form>
<script>
    $('#btnAddOrUpdateService').click(function (e) {
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
                url: '/service',
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
                url: '/service',
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