<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="javascript" type="text/javascript"
	href=<c:url value="/resources/css/validation.js"/> />
<%-- <script type="text/javascript" src="/resources/css/validation.js"></script>--%>
<title>News management project <!-- <bean:message key="locale.linkname.headertitle" />
 -->

</title>

<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/newsStyle.css"/> />

</head>
<body>

	<div class="page">

		<div class="base-layout-wrapper">
			<div class="menu">
				<c:import url="/WEB-INF/pages/menu.jsp" />
			</div>
			
			<c:if test="${not (newsForView eq null)}">
				<div class="content">
					<c:import url="/WEB-INF/pages/viewNews.jsp" />
				</div>
			</c:if>

			<c:if test="${not (allNews eq null)}">
				<div class="content">
					<c:import url="/WEB-INF/pages/viewAllNews.jsp" />
				</div>
			</c:if>


			<c:if test="${not (newsForAdd eq null)}">
				<div class="content">
					<c:import url="/WEB-INF/pages/addNews.jsp" />
				</div>
			</c:if>

			<c:if test="${not (newsForEdit eq null)}">
				<div class="content">
					<c:import url="/WEB-INF/pages/editNews.jsp" />
				</div>
			</c:if>



		</div>

		<%-- <div class="footer">
			<c:import url="/WEB-INF/pages/footer.jsp" />
		</div>--%>

	</div>
</body>
</html>