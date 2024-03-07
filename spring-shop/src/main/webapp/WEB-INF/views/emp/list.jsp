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
<%@ include file="../common/navbar.jsp" %>
<body>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="fs-3">직원관리 - 직원목록</h1>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>					
						<th>이름</th>					
						<th>전화번호</th>					
						<th>이메일</th>					
						<th>급여</th>					
						<th>입사일</th>					
						<th>부서번호</th>									
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${empList }">
						<tr>
							<td>${emp.no }</td>
							<td><a href="detail?no=${emp.no }"> ${emp.name }</a></td>
							<td>${emp.tel }</td>
							<td>${emp.email }</td>
							<td>${emp.salary }</td>
							<td><fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd"/></td>
							<td>${emp.dept.no }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-end">
				<a href="create" class="btn btn-primary">신규등록</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>