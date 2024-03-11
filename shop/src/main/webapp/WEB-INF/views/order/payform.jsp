<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp"  %>
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
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1>주문 - 2단계 (결재정보 입력)</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">
		
		</div>
		<div class="col-9">
			<table class="table">
				<thead>
					<tr>
						<th>상품이름</th>
						<td>아이폰 15</td>
						<th>상품가격</th>
						<td>1,500,000 원</td>
					</tr>
					<tr>
						<th>구매수량</th>
						<td>2 개</td>
						<th>총 구매가격</th>
						<td>3,000,000 원</td>
					</tr>
				</thead>
			</table>
			
			<form class="border bg-light p-3" method="post" action="step3">
				<%-- 시큐리티 사용시 오류방지를 위한 태그 --%>
				<sec:csrfInput/>
			
				<div class="form-group mb-3">
					<label class="form-label">결재수단</label>
					<select class="form-select" name="payType">
						<option value="card">신용가드</option>
						<option value="naverpay" disabled>네이버페이</option>
						<option value="kakaopay" disabled>카카오페이</option>
						<option value="deposit" disabled>무통장입금</option>
					</select>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">카드번호</label>
					<input type="text" class="form-control" name="cardno" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">할부개월수</label>
					<input type="text" class="form-control" name="months" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">결재금액</label>
					<input type="text" class="form-control" name="payAmount" value="3000000" />
				</div>
				<div class="text-end">
					<button type="submit" class="btn btn-primary">결재</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>