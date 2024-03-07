<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>bootstrap</title>
</head>
<%@include file="../common/navbar.jsp" %>
<body>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="fs-3">직원관리 - 신규직원등록</h1>		
		</div>
		
		<form class="border bg-lighit p-3" method="post" action="create">
			<div class="form-group mb-3">
				<label class="form-label">이름</label>
				<input type="text" class="form-control" name="name">
			</div>
			<div class="form-group mb-3">
				<label class="form-label">전화번호</label>
				<input type="text" class="form-control" name="tel">
			</div>
			<div class="form-group mb-3">
				<label class="form-label">이메일</label>
				<input type="text" class="form-control" name="email">
			</div>
			<div class="form-group mb-3">
				<label class="form-label">급여</label>
				<input type="text" class="form-control" name="salary">
			</div>
			<div class="form-group mb-3">
				<label class="form-label">입사일</label>
				<input type="date" class="form-control" name="hrieDate">
			</div>
			<div class="form-group mb-3">
				<label class="form-label">부서번호</label>
				<input type="text" class="form-control" name="detpno">
			</div>
			<div class="text-end">
				<button type="submit" class="btn btn-primary">등록</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>