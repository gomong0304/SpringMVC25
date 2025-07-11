<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- header -->
<%@include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<form role="form" action="/board/modify" method="post">
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name='bno' value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>Title</label> <input class="form-control" name='title' value='<c:out value="${board.title}"/>'>
					</div>

					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name='content'><c:out value="${board.content}"/></textarea>
					</div>

					<div class="form-group">
						<label>Writer</label> <input class="form-control" name='writer' value='<c:out value="${board.writer}"/>'>
					</div>
					<button type="submit" data-oper='modify' class="btn btn-default">수정하기</button>
					<button type="submit" data-oper='remove' class="btn btn-default">삭제하기</button>
					<button type="submit" data-oper='list' class="btn btn-default">목록으로</button>
					<!-- js를 이용해서 submit버튼의 data-oper값에 따른 분기를 설정할꺼임 -->
				</form>

			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

<!-- footer -->
<%@include file="../includes/footer.jsp"%>


<script type="text/javascript">
	$(document).ready(function(){
		
		var formObj = $("form"); // 위에 form 태그를 변수에 넣는다.
		
		$('button').on("click", function(e) {
			e.preventDefault(); 
			// 기존에 세팅된 기능을 사용하지 않겠다.
			// 버튼을 눌러도 action="/board/modify" method="post" 이 기능 사용 안한다.
			
			var operation = $(this).data("oper"); // data-oper='modify', data-oper='remove', data-oper='list'
			
			console.log(operation); // 크롬브라우져 콘솔에 값이 찍힘
			
			if(operation === 'remove'){
				formObj.attr("action","/board/remove");
				// data-oper='remove' -> /board/remove
			}else if(operation === 'list'){
				self.location="/board/list";
				return;
				// data-oper='list' -> /board/list
			}
			// data-oper='modify'는 기본 액션태그 내용대로 진행한다.
			
			formObj.submit(); // submit 버튼 동작 시작!!
		});
	});
</script>
