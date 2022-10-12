<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="javascript" type="text/javascript"
	href=<c:url value="/resources/css/validation.js"/> />

<title>News management project</title>

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
				<div class="body-title">
					<a href="list"> News list </a> View news
				</div>

				<div class="add-table-margin">

					<table class="news_text_format">
						<tr>
							<td class="space_around_title_text">News title:</td>

							<td class="space_around_view_text"><div class="word-breaker">${news.title }</div></td>
						</tr>
						<tr>
							<td class="space_around_title_text">News date:</td>

							<td class="space_around_view_text"><div class="word-breaker">${news.newsDate}</div></td>
						</tr>
						<tr>
							<td class="space_around_title_text">News brief:</td>
							<td class="space_around_view_text"><div class="word-breaker">${news.briefNews}"</div></td>
						</tr>
						<tr>
							<td class="space_around_title_text">News content:</td>
							<td class="space_around_view_text"><div class="word-breaker">${news.content}</div></td>
						</tr>

					</table>

					<c:url var="editLink" value="/news/showFormForEdit">
						<c:param name="newsId" value="${news.idNews}" />
					</c:url>

					<c:url var="deleteLink" value="/news/delete">
						<c:param name="newsId" value="${news.idNews}" />
					</c:url>



					<div class="news-link-to-wrapper">
						<div class="link-position">
							<a href="${editLink}">edit</a> &nbsp </a> &nbsp <a
								href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false">delete</a>
						</div>
						<div align="right">
							<p>
								<a href="list">cansel</a>
							</p>
						</div>
						<div align="right">

							<form:form action="list" method="POST" modelAttribute="news">
								<br />
								<input type="submit" value="Cansel" class="cansel" />
							</form:form>
						</div>
					</div>
				</div>
				<%-- <c:forEach var="theNews" items="${news}">			
				<tr>
					<td class="space_around_title_text">News title:</td>

					<td class="space_around_view_text"><div class="word-breaker">
							${theNews.title }</div></td>
				</tr>
				<tr>
					<td class="space_around_title_text">News date:</td>

					<td class="space_around_view_text"><div class="word-breaker">
							${theNews.newsDate}</div></td>
				</tr>
				<tr>
					<td class="space_around_title_text">News brief:</td>
					<td class="space_around_view_text"><div class="word-breaker">
							${theNews.briefNews}"
						</div></td>
				</tr>
				<tr>
					<td class="space_around_title_text">News content:</td>
					<td class="space_around_view_text"><div class="word-breaker">
							${theNews.content}
						</div></td>
				</tr>
			</c:forEach>--%>


			</div>

			<%-- 
			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="go_to_do_action" /> <input
						type="hidden" name="local" value="${local}" /> <input
						type="hidden" name="idNews" value="${news.idNews}" /> <input
						type="hidden" name="pageNum" value="${pageNum}" /> <input
						type="hidden" name="commandsName" value="edit" /> <input
						type="submit" value="${editNews}" />
				</form>
				<br />

				<form action="controller" method="post">
					<input type="hidden" name="command" value="delete_news" /> <input
						type="hidden" name="local" value="${local}" /> <input
						type="hidden" name="pageNum" value="${pageNum}" /> <input
						type="hidden" name="idNews" value="${news.idNews}" /> <input
						type="submit" onClick="alert('${checkDeleting}')"
						value="${delete}" />
				</form>
				<br />
		

		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_news_list" /> <input
				type="hidden" name="local" value="${local}" /> <input type="hidden"
				name="pageNum" value="${pageNum}" /> <input type="submit"
				value="${cansel}" />

		</form>
</div>
<c:if test="${not(requestScope.news eq null)}">
	<div align="left">

		<form action="controller" method="post">
			<input type="hidden" name="command" value="completely_delete_news" />
			<input type="hidden" name="local" value="${local}" /> <input
				type="hidden" name="pageNum" value="${pageNum}" /> <input
				type="hidden" name="idNews" value="${news.idNews}" /> <font
				color="red"> <input type="submit"
				onClick="alert('${checkDeleting}')" value="${delCompl}" /></font>

			${newsBrief}
		</form>
	</div>
</c:if>--%>

		</div>