<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div>
	<div class="menu-wrapper">
		<div class="menu-title-wrapper">
			<div class="menu-title">News list</div>
		</div>

		<div class="list-menu-invisible-wrapper">
			<div class="list-menu-wrapper" style="float: right;">
				<ul style="list-style-image: url(img.jpg); text-align: left;">
					<li style="padding-left: 15px;">
					
					<a
						href="list">News List</a><br /></li>

					<li style="padding-left: 15px;">
										
					<c:url var="addLink" value="/news/showFormForAdd">		
			
					</c:url>									
					<a href="${addLink}">Add news</a> <br /></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<!--  grey free space at the bottom of menu -->
		<div style="height: 25px;"></div>
	</div>
</div>

