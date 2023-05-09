
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<jsp:include page="/header" />
	
		<div class="container-fluid p-4">
			<div class="col-sm-8 mx-auto p-2">
				<h4>Search Employee</h4>
				
				<form class="mt-2">
					<label>What are you searching for? </label>
					<input type="text" placeholder="Enter employee id or name" name="searchValue" />
					<button class="btn btn-sm btn-primary">SEARCH</button>
				</form>
			</div>
			
		</div>
		
		
		
		<jsp:include page="/footer" />
	