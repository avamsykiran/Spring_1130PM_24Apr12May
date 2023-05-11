
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

		<jsp:include page="/header" />
	                           
		<div class="container-fluid p-4">
			<div class="col-sm-5 mx-auto p-2">
				<h4>Employees Details</h4>
				
				<form:form modelAttribute="emp" method="POST">
					<div>
						<form:label path="empId">Employee Id</form:label>
						<form:input path="empId" class="form-control" type="number" readonly="true" />
					</div>
					<div>
						<form:label path="empName">Employee Name</form:label>
						<form:input path="empName" class="form-control" required="required" />
					</div>
					<div>
						<form:label path="salary">Salary</form:label>
						<form:input path="salary" class="form-control" type="number" required="required" />
					</div>
					<div>
						<form:label path="dateOfJoining">Join Date</form:label>
						<form:input path="dateOfJoining" class="form-control" type="date" required="required" />
					</div>
					<div>
						<form:label path="designation">Designation</form:label>
						<form:select path="designation" class="form-control" required="required" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${designations}"/>
						</form:select>
					</div>
					<div class="d-grid mt-2">
						<button class="btn btn-primary">SAVE</button>
					</div>
				</form:form>
			</div>
			
		</div>
		
		
		
		<jsp:include page="/footer" />
	