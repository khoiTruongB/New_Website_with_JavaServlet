<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	
	
		<div class="main-content">
		<form action="<c:url value='/quan-tri-new'/>" id="formSubmit" method="get" >
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a>
					</ul>
					<!-- /.breadcrumb -->
				</div>
	
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Tên bài viết</th>
													<th>Mô tả ngắn</th>
												</tr>
											</thead>
											<tbody>
											
											<c:forEach var="item" items="${model.listRs }">
												<tr>
													<td>${item.title }</td>
													<td>${item.shortDescription }</td>
	
												</tr>
											</c:forEach>
												
											</tbody>
										</table>
	
	
										<ul class="pagination" id="pagination"></ul> 
										<input type="hidden" value="" id="page" name="page" />
										<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
										<input type="hidden" value="" id="sortName" name="sortName" />
										<input type="hidden" value="" id="sortBy" name="sortBy" />
									</div>
								</div>
							</div>
						</div>
	
						<!-- /.page-content -->
					</div>
				</div>
	
	
			</div>
	
		
			</form>
		</div>
		<!-- <!-- /.main-content -->

	<script type="text/javascript">
	var totalPages = ${model.toltalPage};
	var currenPage = ${model.page};
	var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currenPage,
            onPageClick: function (event, page) {
            	if(currenPage != page){
            		//console.info(page + ' (from options)');
                    $('#maxPageItem').val(limit);//lấy value của input
                    $('#page').val(page);//lấy value của input
                    $('#sortName').val('title');//lấy value của input
                    $('#sortBy').val('desc');//lấy value của input
                    $('#formSubmit').submit();//gọi id form và submit form
            	}
                
            }
        });
    });
</script> -->
</body>
</html>