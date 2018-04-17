<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>쇼핑몰 관리자 홈페이지</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
<script
	src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js"
	type="text/javascript"></script>
	
	
<script>

$(function() {

	$("#btn-categoryadd")
			.click(
					function() {

		
						var posttype = $("#posttype1").val();
					
						if (posttype=="") {
							console.log("hhhhhhhhhh");
							return;
						}
						
						$
								.ajax({
									url : "${pageContext.servletContext.contextPath }/api/user/categoryadd?posttype="
											+posttype + "&user_no="+ ${authUser.no},
									type : "get",
									data :""
									/* {
										"name":name,
										"content":content
									} */,
									dataType : "json", //응답 받을 데이터 타입
									success : function(response) {
									
										
											$('#cate-table tr:first').after(
											 // bgcolor='"+#F2F2F2+"'height='"+23+"'
													"<tr>" +
													"<td>"+$('#cate-table tr').length+"</td>"+
													"<td>"+posttype+"</td>"+
													"<td><image class = 'cate-delete' data-no='"+response.cate_no+ 
													"'></td>"+
													"</tr>"
												
													
													
													);

									},
									error : function(xhr, status, e) {
										console.error(status + ":" + e);
									}

								});
					

					});

});

$(document).on("click", ".cate-delete", function(){
	var tmp = $(this); 
	var no = tmp.attr("data-no")
	console.log(no);
	$
	.ajax({
	url : "${pageContext.servletContext.contextPath}/api/user/categorydelete", //요청할 URL
	dataType : "json", //응답받을 데이터타입
	type : "post", //요청 방식
	data : {"no" : no}, //서버에 요청시 보낼 파라미터 ex) {name:홍길동}
	success : function(response) { //요청 및 응답에 성공했을 경우
	tmp.closest("tr").remove();
	},
	error : function(xhr, status, e) { //요청 및 응답에 실패 한 경우
	console.error(status + ":" + e);

	}
	});
	})











</script>	
	
</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>
<form name="form1" method="get" action="">
<table width="800" border="0" cellspacing="0" cellpadding="0">
	<tr height="40">
		<td align="left"  width="150" valign="bottom">&nbsp 제품수 : <font color="#FF0000">${map.count }</font></td>
		<td align="right" width="550" valign="bottom">
			
			<input type="text" name="text1" size="10" value="">&nbsp
		</td>
		<td align="left" width="120" valign="bottom">
			<input type="submit" value="검색">
			&nbsp;
			<a href="${pageContext.servletContext.contextPath }/${authUser.id}/product_new"><input type="button" value="새상품"></a>
		</td>
	</tr>
	<tr><td height="5"></td></tr>
</table>
</form>

<table class="admin-cat" id = "cate-table" width="800" border="1" cellspacing="0" bordercolordark="white" bordercolorlight="black">
	<tr bgcolor="#CCCCCC" height="23"> 
		<td width="100" align="center">분류 번호</td>
		<td width="100" align="center">제품 분류</td>
		<td width="80"  align="center">삭제</td>
	</tr>
	
	<c:set var = "count" value="${fn:length(map.list) }"/>
	<c:forEach items="${ map.list }" var="list" varStatus="status">
	<tr bgcolor="#F2F2F2" height="23">	
		<td align="center" width="100">${count-status.index}</td>
		<td align="center" width="100">${list.posttype }</td>
		
		<td width="80"  align="center">
			
			<a class ="cate-delete" data-no="${list.cate_no }" href="">삭제</a>
		</td>
	</tr>
	</c:forEach>
	<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<!--  <form action="${pageContext.servletContext.contextPath }/blog/categoryadd" method="post">-->
		      	
		      	<table id="admin-cat-add">
		      	
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input id="posttype1" type="text" name="content"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input id="btn-categoryadd" type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
</table>

<br>
<table width="800" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="30" class="cmfont" align="center">
			<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_prev.gif" align="absmiddle" border="0"> 
			<font color="#FC0504"><b>1</b></font>&nbsp;
			<a href="product.jsp?page=2&sel1=&sel2=&sel3=&sel4=&text1="><font color="#7C7A77">[2]</font></a>&nbsp;
			<a href="product.jsp?page=3&sel1=&sel2=&sel3=&sel4=&text1="><font color="#7C7A77">[3]</font></a>&nbsp;
			<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_next.gif" align="absmiddle" border="0">
		</td>
	</tr>
</table>
</body>
</html>