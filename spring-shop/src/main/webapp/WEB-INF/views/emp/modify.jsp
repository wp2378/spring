<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/tags.jsp" %>
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
<body>
<%@include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="fs-3">직원관리 - 직원정보수정</h1>
			
			<form class="border bg-lighit p-3" method="POST" action="modify">
				<div class="form-group mb-3">
					<input type="hidden" value="${emp.no }" class="form-control" name="no">
				</div>
				<div class="form-group mb-3">
					<label class="form-label">이름</label>
					<input type="text" value="${emp.name }" class="form-control" name="name">
				</div>
				<div class="form-group mb-3">
					<label class="form-label">전화번호</label>
					<input type="text" value="${emp.tel }" class="form-control" name="name">
				</div>
				<div class="form-group mb-3">
					<label class="form-label">이메일</label>
					<input type="text" value="${emp.email }" class="form-control" name="tel">
				</div>
				<div class="form-group mb-3">
					<label class="form-label">급여</label>
					<input type="text" value="${emp.salary }" class="form-control" name="salary">
				</div>
				<div class="form-group mb-3">
					<label class="form-label">소속부서</label>
					<select class="form-control" name="deptNo">
						<c:forEach var="dept" items="${deptList }" >
							<option value="${dept.no }" ${dept.no eq emp.dept.no ? 'selected' : '' }>${dept.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">입사일</label>
					<fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd" var="hireDate"/>
					<input type="date" value="${hireDate }" class="form-control" name="hireDate">
				</div>
				<div class="text-end">
					<button type="submit" class="btn btn-primary">수정</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>