
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

		<jsp:include page="/header" />
	
		<div class="container-fluid p-4">
			<div class="col-sm-6 mx-auto p-2">
				<h4>Friends Page</h4>
		
				<form>
					<label>What's your friends's name?</label>
					<input type="text" name="fnm" class="form-control" />
					<div class="d-grid mt-1">
						<button class="btn btn-primary">Add My Friend ! </button>
					</div>
				</form>
				
				<c:if test="${friends != null && !friends.isEmpty()}">
					<ol>
						<c:forEach items="${friends}" var="friend">
							<li>${friend}</li>
						</c:forEach>
					</ol>
				</c:if>
		
			</div>	
		</div>
		
		
		
		<jsp:include page="/footer" />
	