<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div>
	<fmt:setLocale value="${sessionScope.local}" />
	<fmt:setBundle basename="localization.local" var="loc" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.news"
		var="newsShow" />	
	<fmt:message bundle="${loc}" key="local.locbutton.name.latestNews"
		var="latestNews" />

	<div class="body-title">

		<a href="controller?command=go_to_news_list&local=${local}">${newsShow} </a> ${latestNews}
	</div>

	<form action="command.do?method=delete" method="POST">
		
			<c:forEach var="news" items="${allNews}">
				<div class="single-news-wrapper">
					<div class="single-news-header-wrapper">
						<div class="news-title">
							${allNews.title}
						</div>
						<div class="news-date">
							${allNews.newsDate}
						</div>

						<div class="news-content">
							${allNews.briefNews}
						</div>
					</div>

				</div>

			</c:forEach>

			<div class="no-news">
				<c:if test="${allNews eq null}">
               No news.
	       </c:if>
			</div>
	

	</form>
</div>
