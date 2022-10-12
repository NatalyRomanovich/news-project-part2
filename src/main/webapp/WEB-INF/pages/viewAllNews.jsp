<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="body-title"></div>

<div>
	<%-- <form:form action="delete" modelAttribute="theNews" method="POST">--%>
		<c:forEach var="theNews" items="${allNews}">
			<%-- <form:hidden path="idNews" />--%>

			<%--<input type="checkbox" name="bulkwelcome" class="bulkwelcome"
				id="bulkwelcome_${theNews.idNews }" value="${theNews.idNews }" />&nbsp;--%>
			
			<div class="single-news-wrapper">
				<div class="single-news-header-wrapper">
					<!-- construct an "update" link with customer id -->
					<c:url var="editLink" value="/news/showFormForEdit">
						<c:param name="newsId" value="${theNews.idNews}" />
					</c:url>

					<c:url var="viewLink" value="/news/view">
						<c:param name="newsId" value="${theNews.idNews}" />
					</c:url>
					
					<c:url var="deleteLink" value="/news/delete">
						<c:param name="newsId" value="${theNews.idNews}" />
					</c:url>
					
					<div class="single-news-wrapper">
						<div class="single-news-header-wrapper">
							<div class="news-title">${theNews.title}</div>
							<div class="news-date">${theNews.newsDate}</div>
							<div class="news-content">${theNews.briefNews}</div>
						</div>
					</div>

					<div class="news-link-to-wrapper">
						<div class="link-position">
							<a href="${editLink}">edit</a> &nbsp 
							<a href="${viewLink}"> view</a> &nbsp 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false">delete</a>
						</div>
					<%--	<form:checkboxes path="idNews"
							items="${theNews.briefNews}" />
						<input type="submit" value="Delete" class="delete"/>--%>
					</div>
				</div>
			</div>
		</c:forEach>

	<%--</form:form>--%>

	<!--  <div class="no-news">
		<c:if test="${allNews eq null}">
               No news.
	       </c:if>
	</div>-->
</div>
