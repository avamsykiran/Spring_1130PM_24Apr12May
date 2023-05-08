
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<jsp:include page="/header" />
	
		<div class="container-fluid p-4">
			<h4>Welcome Home!</h4>
			<p>This is a small Spring Web MVC based web application running 
				on Spring Boot and Embeded Tomcat Server and uses JSP as View Engine.
			<p>
		
			<form class="col-sm-6 mx-auto">
				<label>What's your name?</label>
				<input type="text" name="unm" class="form-control" />
				<div class="d-grid mt-1">
					<button class="btn btn-primary">Okay ! </button>
				</div>
			</form>
			
			<c:if test="${message != null}">
				<p class="alert alert-info p-2 col-sm-6 mx-auto fw-bold">
					${message}
				</p>
			</c:if>
			
		</div>
		
		
		
		<jsp:include page="/footer" />
	