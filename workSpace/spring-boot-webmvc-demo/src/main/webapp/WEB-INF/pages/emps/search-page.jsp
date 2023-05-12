
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
				
				<c:choose>
					<c:when test="${emps==null || emps.isEmpty() }">
						<p class="alert alert-info mt-2 p-2 fw-bold">
							No employees found!
						</p>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Emp#</th>
									<th>Name</th>
									<th>Salary</th>
									<th>Join Date</th>
									<th>Designation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${emps }" var="emp">
									<tr>
										<td>${emp.empId }</td>
										<td>${emp.empName }</td>
										<td>${emp.salary }</td>
										<td>${emp.dateOfJoining }</td>
										<td>${emp.designation }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			
		</div>
		
		
		
		<jsp:include page="/footer" />
	