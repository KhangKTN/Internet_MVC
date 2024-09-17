<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-primary">Register Computer</h1>
<form id="formSubmit">
    <div class="row">
        <div class="col">
            <label class="form-label">Choose Customer</label>
            <select name="customerId" class="form-select">
                <c:forEach var="customer" items="${customerList}">
                    <option value="${customer.id}">${customer.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col">
            <label class="form-label">Choose Computer</label>
            <select name="computerId" class="form-select">
                <c:forEach var="computer" items="${computerList}">
                    <option value="${computer.id}">${computer.id}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div>

    </div>
    <input type="hidden" value="" id="startDate" name="startDate"/>
    <input type="hidden" value="" id="startTime" name="startTime"/>
    <input type="hidden" value="0" id="timeUsed" name="timeUsed"/>
    <button id="btnAddOrUpdateRegister" class="btn btn-primary mt-3">Register</button>
</form>
<script>
    $('#btnAddOrUpdateRegister').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        var id = $('#id').val();
        console.log(data)
        add(data);

        // else update(data)

        function add(data) {
            $.ajax({
                url: '/register-computer',
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
    })
</script>