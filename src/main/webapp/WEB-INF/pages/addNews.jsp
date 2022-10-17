<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="javascript" type="text/javascript"
	href=<c:url value="/resources/css/validation.js"/> />

<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href=<c:url value="/resources/css/newsStyle.css"/> />

</head>
<body>
	<div class="page">

		<div class="base-layout-wrapper">
			<div class="menu">
				<c:import url="/WEB-INF/pages/menu.jsp" />
			</div>

			<div class="content">
				<a href="list">News List</a><br />

				<div class="add-table-margin">
					<div align="left">
						<form:form action="saveNews" method="POST" modelAttribute="news">

							<form:hidden path="idNews" />
							<label> News title: <form:input type="text" name="title"
									path="title" size="95" maxlength="150" required="required" /><br />
							</label>
							<label>News date:<br /> <form:input type="date"
									name="date" path="newsDate" size="15" maxlength="150"
									required="required" /><br />
							</label>
							<label>News brief:<br /> <form:input type="text"
									name="brief" path="briefNews" size="95" maxlength="150"
									required="required" /><br />
							</label>
							<label>News content:<br /> <form:input type="text"
									name="content" path="content" size="95" maxlength="10000"
									required="required" /> <br />
							</label>
							<div align="right">
								<br /> <input type="submit" value="Save" class="save" />
							</div>
						</form:form>

						<div align="right">

							<form:form action="list" method="POST" modelAttribute="news">
								<br />
								<input type="submit" value="Cansel" class="cansel" />
							</form:form>
						</div>

						<!--<div align="right">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_news_list" /> <input
				type="hidden" name="local" value="${local}" /> <input type="hidden"
				name="pageNum" value="${pageNum}" /> <input type="submit"
				value="${cansel}" /><br />
		</form>
	</div> -->
					</div>
				</div>
			</div>
		</div>
</body>
</html>
