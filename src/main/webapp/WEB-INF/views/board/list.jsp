<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<!-- header -->
	<%@ include file="../includes/header.jsp" %> <!-- 위쪽에 반복되는 메뉴들을 헤더로 꽂음. -->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           MBCBoard List Page
                           <button id='regBtn' type="button" class="btn btn-xs pull-right">게시글 등록</button> <!-- 이버튼을 눌렀을때 동작을 하도록 자바스크립트로 보낸다. -->
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body"> <!-- 필드명 쓰는곳 -->
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>#번호</th> <!-- #은 pk인 경우 테스트용으로 넣음 -->
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <!-- model에서 전달된 리스트를 출력한다. -->
                                <c:forEach items="${list}" var="board"> 
                                <!-- 컨트롤러에서 전달된 리스트+제네릭 처리용 -->
                                <!-- 서비스에서 만들어져 나옴 List<BoardVO> -->
                                <!-- 컨트롤러에서 model.addAttribute("list", service.getList()); -->
                                	<tr>
                                		<td><c:out value="${board.bno}" /></td>
                                		<td>
                                			<a href='/board/get?bno=<c:out value="${board.bno}" />'>
                                			<!-- 리스트의 제목을 눌렀을때 작동한다. get방식으로 URL이 생성됨 -->
                                			<!-- 근데 프론트가 생성이 안되서 get.jsp 생성 -->
                                				<c:out value="${board.title}" />
                                			</a>
                                		</td>
                                		<td><c:out value="${board.writer}" /></td>
                                		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}" /></td>
                                		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>
                                	</tr>
                                </c:forEach>  
                             </table>
                             
                             <!-- Modal 추가 p248 경고창 대신 모달 사용 -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                    	<!-- header -->
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">MBCBoard</h4>
                                        </div>
                                        <div class="modal-body">
                                        	처리가 완료 되었습니다.
                                        </div>
                                        <!-- footer -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                                            <button type="button" class="btn btn-primary">저장(적용)</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal 종료-->
                             
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
       
	<!-- footer -->
	<%@ include file="../includes/footer.jsp" %> <!-- 아래쪽에 반복되는 메뉴들을 footer로 꽂음. -->

	<script type="text/javascript"> /* CRUD 처리결과 메세지를 출력하는 코드 */
		$(document).ready(
			function() {
				var result = '<c:out value="${result}"/>';
				
				checkModal(result);
				
				function checkModal(result) {
					
					if(result === ''){
						return; // 입력값이 없으면 그냥 돌아감
					}
					
					if(parseInt(result)>0){
						// 게시물 등록 번호가 넘어오면
						$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다."); 
						// modal-body영역의 글자를 html()안의 내용으로 교체한다.
					}
					
					$("#myModal").modal("show"); // 모달창을 화면에 띄워라!
					
				}// 모달 처리 종료
				
				/* ------------------------------------------------------------------------------- */
				
				/* regBtn버튼 클릭시 작동하는 js */
				$("#regBtn").on("click", function(){
					// regBtn id를 갖는 버튼을 클릭하면 익명의 함수를 실행한다.
					self.location = "/board/register";
					// 위치를 이동해라 http://192.168.111.104:80/board/register로 이동한다.
				});
				
			}	
			
			/* 백엔드에서 처리 결과를 받는 변수를 연동함. */	
			/* 등록시 : rttr.addFlashAttribute("result",board.getBno()); */
			/* 수정시 : rttr.addFlashAttribute("result", "success"); */
			/* 삭제시 : rttr.addFlashAttribute("result", "success"); */
			
		);
	</script>