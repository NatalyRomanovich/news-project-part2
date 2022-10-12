<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div>
	<div class="menu-wrapper">
		<div class="menu-title-wrapper">
			<div class="menu-title">${newsShow}</div>
		</div>

		<div class="list-menu-invisible-wrapper">
			<div class="list-menu-wrapper" style="float: right;">
				<ul style="list-style-image: url(images/img.jpg); text-align: left;">
					<li style="padding-left: 15px;"><a
						href="controller?command=go_to_news_list&local=${local}&pageNum=${pageNum}">${newsList}</a><br /></li>

					<li style="padding-left: 15px;">
					
					<c:forEach var="news" items="${allNews}">
					<c:url var="addLink" value="/news/showFormForAdd">
					
					<c:param name="newsId" value="${news.idNews}" />
					</c:url>
					
					</c:forEach>
					<a href="${addLink}">Add news</a> <br /></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<!--  grey free space at the bottom of menu -->
		<div style="height: 25px;"></div>
	</div>
</div>

