<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<footer style="position:absolute;bottom:1px;width:100%;background-color:#000000;text-align:right;padding:2px;font-weight:bold;color:#ffffff">
	<h5>
		Developed By | 
		<c:forEach items="${team}" var="member">
			<span> ${member} | </span>
		</c:forEach>
	</h5>
</header>