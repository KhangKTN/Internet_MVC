<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-primary">List Service</h1>
<form id="formSubmit" method="get">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <%--                            <c:if test="${not empty messageResponse}">--%>
                    <%--                                <div class="alert alert-${alert}">--%>
                    <%--                                        ${messageResponse}--%>
                    <%--                                </div>--%>
                    <%--                            </c:if>--%>
                    <div class="widget-box table-filter">
                        <div class="table-btn-controls">
                            <div class="pull-right tableTools-container">
                                <div class="dt-buttons btn-overlap btn-group">
                                    <a flag="info"
                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                       title='Thêm bài viết' >
                                                    <span>
                                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                    </span>
                                    </a>
                                    <button id="btnDelete" type="button"
                                            class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th><input type="checkbox" id="checkAll"></th>
                                        <th>Service ID</th>
                                        <th>Name</th>
                                        <th>Unit</th>
                                        <th>Price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${model.listResult}">
                                        <tr>
                                            <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <td>${item.id}</td>
                                            <td>${item.name}</td>
                                            <td>${item.unit}</td>
                                            <td>${item.price}</td>
                                            <td>
                                                <c:url var="editURL" value="/listService">
                                                    <c:param name="type" value="edit"/>
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                   title="Update computer" href='${editURL}'><i class="fa-solid fa-pen-to-square"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <ul class="pagination" id="pagination"></ul>
                                <input type="hidden" value="" id="page" name="page"/>
                                <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                <input type="hidden" value="" id="sortName" name="sortName"/>
                                <input type="hidden" value="" id="sortBy" name="sortBy"/>
                                <input type="hidden" value="" id="type" name="type"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val('title');
                    $('#sortBy').val('desc');
                    $('#type').val('list');
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>
<script>
</script>
