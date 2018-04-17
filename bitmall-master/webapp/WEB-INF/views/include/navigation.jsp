<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
			<table width="181" border="0" cellspacing="0" cellpadding="0">
				<tr> 
					<td valign="top"> 
						<!--  Category 메뉴 : 세로인 경우 -------------------------------->
						<table width="177"  border="0" cellpadding="2" cellspacing="1" bgcolor="#ffffff">
							
							<tr><td height="30" bgcolor="#ffffff" align="center" style="font-size:16pt;color:#333333;font-family:palatino"><b>C a t e g o r y</b></td></tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/product/1"><img src="${pageContext.servletContext.contextPath }/assets/images/logo/kakaologo.png" width="176" height="50" border="0"  onmouseover="img_change('on')" onmouseout="img_change('off')"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/product/2"><img src="${pageContext.servletContext.contextPath }/assets/images/logo/pokelogo.jpg" width="176" height="50" border="0"  onmouseover="img_change('on')" onmouseout="img_change('off')"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/product/3"><img src="${pageContext.servletContext.contextPath }/assets/images/logo/overactionlogo.PNG" width="176" height="50" border="0"  onmouseover="img_change('on')" onmouseout="img_change('off')"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/product/4"><img src="${pageContext.servletContext.contextPath }/assets/images/logo/minglogo.PNG" width="176" height="50" border="0"  onmouseover="img_change('on')" onmouseout="img_change('off')"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/product/5"><img src="${pageContext.servletContext.contextPath }/assets/images/logo/onelogo.jpg" width="176" height="30" border="0"  onmouseover="img_change('on')" onmouseout="img_change('off')"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/product/6"><img src="${pageContext.servletContext.contextPath }/assets/images/logo/zzanglogo.png" width="176" height="50" border="0"  onmouseover="img_change('on')" onmouseout="img_change('off')"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/product/7"><img src="${pageContext.servletContext.contextPath }/assets/images/logo/doolylogo.PNG" width="176" height="50" border="0"  onmouseover="img_change('on')" onmouseout="img_change('off')"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/product/8"><img src="${pageContext.servletContext.contextPath }/assets/images/logo/bonologo.PNG" width="176" height="50" border="0"  onmouseover="img_change('on')" onmouseout="img_change('off')"></a></td></tr>
									</table>
								</td>
							</tr>
							
						</table>
					</td>
				</tr>
				<tr><td height="10"></td></tr>
				<tr> 
					<td> 
						<!--  Custom Service 메뉴(QA, FAQ...) -->
						<table width="177"  border="0" cellpadding="2" cellspacing="1" bgcolor="#afafaf">
							<tr><td height="3"  bgcolor="#a0a0a0"></td></tr>
							<tr><td height="25" bgcolor="#f0f0f0" align="center" style="font-size:11pt;color:#333333"><b>Customer Service</b></td></tr>
							<tr>
							<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="${pageContext.servletContext.contextPath }/user/faq"><img src="${pageContext.servletContext.contextPath }/assets/images/main_left_faq.gif" border="0" width="176"></a></td></tr>
									</table>
								</td>
							
							</tr>
							<tr>
									<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
									<!--  	<tr><td><a href="qa"><img src="${pageContext.servletContext.contextPath }/assets/images/main_left_qa.gif" border="0" width="176"></a></td></tr>-->
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="#"><img src="${pageContext.servletContext.contextPath }/assets/images/main_left_etc.gif" border="0" width="176"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="#"><img src="${pageContext.servletContext.contextPath }/assets/images/main_left_etc.gif" border="0" width="176"></a></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%"  border="0" cellspacing="0" cellpadding="0">
										<tr><td><a href="#"><img src="${pageContext.servletContext.contextPath }/assets/images/main_left_etc.gif" border="0" width="176"></a></td></tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>