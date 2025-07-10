<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl 라이브러리 필수 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error_page</title>
</head>
<body>

	<h2>예외 발생!!!</h2>

	<h4><c:out value="${exception.getMessage()}"></c:out></h4>
	<!-- 			  표현식 :  모델 객체에 있는 데이터를 출력하는 코드	 -->
	
	<ul>
		<c:forEach items="${exception.getStackTrace()}" var="stack"> 
		<!-- forEach문은 향상된 for문으로 인덱스를 사용하지 않고 반복하는 용 -->
		<!-- 											var="stack" 반복하며 가져온 객체 저장소	 -->
			<li>
				<c:out value="${stack}"></c:out>
			</li>
		</c:forEach> <!-- for문 종료 -->
	</ul>
</body>
</html>